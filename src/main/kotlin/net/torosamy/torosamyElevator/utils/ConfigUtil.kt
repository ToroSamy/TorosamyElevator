package net.torosamy.torosamyElevator.utils

import net.torosamy.torosamyCore.manager.ConfigManager
import net.torosamy.torosamyElevator.TorosamyElevator
import net.torosamy.torosamyElevator.config.LangConfig
import net.torosamy.torosamyElevator.config.MainConfig


class ConfigUtil {
    companion object {
        var mainConfig: MainConfig = MainConfig()
        var langConfig: LangConfig = LangConfig()

        private var mainConfigManager: ConfigManager = ConfigManager(mainConfig, TorosamyElevator.plugin,"","config.yml")
        private var langConfigManager: ConfigManager = ConfigManager(langConfig, TorosamyElevator.plugin,"","lang.yml")


        fun reloadConfig() {
            mainConfigManager.load()
            langConfigManager.load()
        }

        fun saveConfig() {
            mainConfigManager.save()
            langConfigManager.save()
        }
    }
}