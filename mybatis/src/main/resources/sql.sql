CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  `username` VARCHAR(32) NOT NULL UNIQUE COMMENT '用户名',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  `create_time` DATETIME NOT NULL DEFAULT NOW() COMMENT '创建时间',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';



INSERT INTO `user`(`username`,`password`) VALUES ('test1', '412365a109674b2dbb1981ed561a4c70');
INSERT INTO `user`(`username`,`password`) VALUES ('test2', '412365a109674b2dbb1981ed561a4c70');