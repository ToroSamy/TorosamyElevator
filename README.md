## Dependency
- TorosamyCore
## Usage
1. download [TorosamyCore](https://github.com/ToroSamy/TorosamyCore) as a dependency plugin
2. put the **dependencies** and this plugin into your plugins folder and start your server
3. Modify the default configuration file generated and restart your 
## Permission
- - **Usage:** /te reload
  - **Description:** reload this plugin
  - **Permission:** torosamyElevator.reload
- - **Usage:** /te toggle
  - **Description:** switch the player's usage status
  - **Permission:** torosamyElevator.toggle

## Config

### config.yml
```yml
min-distance: 5
max-distance: 255
#不启用的世界
disable-worlds: []
#不启用的玩家
disable-players: []
#启用的物品材质:
enable-item: IRON_BLOCK
```

### lang.yml
```yml
reload-message: "&b[服务器娘]&a插件 &eTorosamyElevator &a重载成功喵~"
toggle-open: "&b[服务器娘]&a成功 &e开启 &a方块电梯喵~"
toggle-close: "&b[服务器娘]&a成功 &e关闭 &a方块电梯喵~"
```

## Contact Author

- qq: 1364596766
- website: https://www.torosamy.net

## License

[MIT](./LICENSE)
