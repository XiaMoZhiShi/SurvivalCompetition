![banner.png](https://bu.dusays.com/2022/09/25/632ffe6cb4c6b.png)
# 生存竞赛 - Survival Competition
## 这是什么？
一个类似于猎人游戏的竞赛小游戏 Paper 插件，支持自定义队伍、游戏阶段等  
本插件依赖于 Multiverse 部分插件以实现多世界支持等，感谢他们的努力  

## 特点
+ 支持实时创建新的比赛场地
+ 支持修改游戏部分的阶段
+ 支持添加多队伍
+ ~~支持了很多 bugs~~

## 使用
1. 下载编译好的插件 jar 文件
2. 放到服务器 plugins 文件夹中
3. (Optional) 添加插件配置（队伍、游戏阶段等）
4. ~~打五把 CSGO~~ Go!

## TO-DO List
- [ ] 重写游戏进程 （目前的想法大概这样：按照占比分配每个环节的时间，把实际的发展时间等处理好）
  - [x] 重写分队机制 ( math.random() 以支持多个队伍匹配 )
    - [x] 允许通过config添加/删除队伍
  - [x] 重写指令 （现在的也太简陋了吧啊喂）
  - [ ] 重写时间管理逻辑 （从 config 读取，允许用指令修改）
    - [x] 从config读取
    - [ ] 允许用指令修改
  - [ ] 允许用指令修改游戏的默认设置（死亡不掉落、难度这种，应用于新创建的世界，并且从 config 读取）
- [x] 修复无法重生在主世界的 bug
- [x] 权限相关（你也不想任何人都能reloadconfig和stopcurrent吧）
- [x] 处理玩家中途退出并在游戏结束后重新加入的情况（目前插件似乎不会检查加入的玩家之前有没有进过游戏，会导致能把职业属性带到游戏外）
- [ ] 统一命名标准
- [x] 完成这个 README (
- [ ] 忘记了，下次再补（

### Made by XiaMoMC Dev Team
