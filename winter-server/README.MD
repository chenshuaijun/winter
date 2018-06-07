



```
## docker 创建镜像
docker build -t winter/winter-server:v1.0.0 ./

## -v /data/mysql:/var/lib/mysql 系统关在目录 

##  -p 3300:3300 设置映射端口 -1 随机分配 
docker run --name winter-server  -p 3300:3300 -d winter/winter-server:v1.0.0
 
## docker run --name winter-server  -d winter/winter-server:v1.0.0
```
