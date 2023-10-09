# mirai-console-nbnhhsh
[能不能好好说话](https://github.com/itorr/nbnhhsh)的[mirai-console](https://github.com/mamoe/mirai)插件

# 插件依赖
- [mirai-console](https://github.com/mamoe/mirai) 2.15及以上
- [chat-command](https://github.com/project-mirai/chat-command)

# 使用方法
下载[release](https://github.com/yuki-sn0w/mirai-console-nbnhhsh/releases)中的mirai2.jar文件，并将其放入bot工作目录中的`plugins`目录中，随后重启mirai即可

# 指令列表
若出现发送指令后bot无响应的情况，请检查[chat-command](https://github.com/project-mirai/chat-command)是否安装，权限是否分配。

`<...>` 尖括号为必填参数，以`/`斜杠分隔的参数是等价的，可选择任意一个

## 查询缩写

`权限id: net.moeyuki.mirai.mirai-console-nbnhhsh:command.hhsh`

|                    指令                    |         说明          |
|:-----------------------------------------:|:---------------------:|
| /hhsh \<search/查询/查询缩写/缩写查询\> \<text\> | 查询缩写`text`对应的全称 |

举例
```
/hhsh search hhsh
/hhsh 查询 yyds
```

举例的两种方式是等价的
