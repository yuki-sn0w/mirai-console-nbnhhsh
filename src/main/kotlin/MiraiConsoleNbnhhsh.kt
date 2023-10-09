package net.moeyuki.mirai.nbnhhsh

import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.unregister
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info
import net.moeyuki.mirai.nbnhhsh.command.Search

object MiraiConsoleNbnhhsh : KotlinPlugin(
    JvmPluginDescription.loadFromResource()
) {
    override fun onEnable() {
        logger.info { "给我好好说话！" }
        Search.register()
    }
    override fun onDisable() {
       Search.unregister()
    }
}