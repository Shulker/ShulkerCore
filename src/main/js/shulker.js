/*
 * Copyright © 2018 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of shulker.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

// Load Nashorn compatibility script
load("nashorn:mozilla_compat.js");

// Import base packages
importPackage(java.lang, java.util, java.util.stream);

function registerCommand(plugin, object)
{
  if (object.usageGetter === undefined)
    object.usageGetter = (sender) => object.usage;
  if (object.descriptionGetter === undefined)
    object.descriptionGetter = (sender) => object.description;

  let command = plugin.newCommand(object.name)
                      .usage(object.usage)
                      .usage(object.usageGetter)
                      .description(object.description)
                      .description(object.descriptionGetter)
                      .permission(object.permission)
                      .aliases(object.aliases)
                      .executor(object.executor)
                      .tabCompleter(object.tabCompleter)
                      .build();
  plugin.registerCommand(command)
}

function newResource(domain, name)
{
  return new ResourceName(domain, name);
}

function log(msg)
{
  __SHULKER__.logInfo(msg)
}

function loadDependency(name)
{
  let pluginsFile = __SHULKER__.getPluginsDirectory();
  load(new java.io.File(pluginsFile, name).getAbsolutePath())
}