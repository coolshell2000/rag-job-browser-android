# RAG 工作浏览器 Android 应用

这是一个与RAG（检索增强生成）工作数据库系统交互的Android应用程序。

## 功能

- 浏览从网络爬虫收集的工作职位
- 搜索特定工作职位
- 查看工作详情
- 直接在浏览器中申请工作

## 技术栈

- Android SDK
- Java
- Retrofit (网络请求)
- RecyclerView (列表显示)
- CardView (卡片布局)

## API 接口要求

此应用需要连接到运行在本地的Flask后端服务，该服务需要提供以下API端点：

- GET /api/jobs - 获取所有工作
- GET /api/jobs/search?q={query} - 搜索工作

## 如何运行

1. 确保RAG系统的Flask后端服务正在运行（默认端口5000）
2. 使用Android Studio打开项目
3. 同步项目依赖
4. 在模拟器或真实设备上运行应用

## 注意事项

- 应用使用IP地址10.0.2.2连接到本地主机（适用于Android模拟器）
- 如果在真实设备上运行，请确保设备与后端服务在同一网络中，并修改IP地址
- 需要授予应用网络访问权限
