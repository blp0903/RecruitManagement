﻿<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>招聘信息</title>
    <link rel="shortcut icon" href="${ctx!}/images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${ctx!}/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet" />
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${ctx!}/css/detail.css" rel="stylesheet" />
</head>
<body>
    <!-- 导航 -->
    <nav class="blog-nav layui-header">
        <div class="blog-container">
            <!-- 用户登陆 -->
            <div class="blog-user"></div>

            <!-- 导航菜单 -->
            <ul class="layui-nav" lay-filter="nav">
                <li class="layui-nav-item layui-this">
                    <a href="home.html"><i class="fa fa-home fa-fw"></i>&nbsp;招聘信息</a>
                </li>

                <li class="layui-nav-item">
                    <a href="resource.ftl"><i class="fa fa-tags fa-fw"></i>&nbsp;个人中心</a>
                </li>
            </ul>
            <!-- 手机和平板的导航开关 -->
            <a class="blog-navicon" href="javascript:;">
                <i class="fa fa-navicon"></i>
            </a>
        </div>
    </nav>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
            <div class="blog-main">
                <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                	<a href="index.ftl" title="网站首页">网站首页</a>
                	<a href="article.html" title="文章专栏">招聘信息</a>
                	<a><cite class="title"></cite></a>
           		</blockquote>
                <!--左边文章列表-->
                <div class="blog-main-left animated slideInLeft">
                	<!-- 文章内容（使用Kingeditor富文本编辑器发表的） -->
                    <div class="article-detail shadow">
                        <div class="article-detail-title title"><i class="layui-icon">&#xe609;</i>Java高级工程师  14k-18k/月</a></div>
                        <div class="article-detail-info">
                        	<span>编辑时间：2017/3/18 17:30:22</span>
                            <span>作者：北京</span>
                            <span>浏览量：6</span>
                        </div>
                        <div class="article-detail-content">
                             从准备实施个人博客这个计划，到现在一个月不到，准备的东西很少，想着先运营起来再说，边测试边改版，吸取广大好友的意见，针对问题慢慢改进。有了这个发版也是博主，撸了一晚上，
                            第一次配置服务器，有些地方总会遇到问题，索性，解决了，关于网页加载慢的问题，博主正在积极解决!请小主们稍安勿躁。
                            <br><br>
                            有想法有意见，欢迎点击有边关注我与我交流。时间有限，留言功能还未上线
                            <br><br>
                            目前这个v0.1版本，是纯前端组成，还没有涉及后端。中间有段时间一直在想如果数据太多了，用纯前端是不是我这布局会有问题，页面会不会变形，并且自己花了一天时间
                            也搭了一个带后台的项目，后台是java实现的，使用了一个spring boot框架，感觉修改一些页面样式，太麻烦了，每次都得重启服务，想想第一版，应该不会有太多数
                            据吧!就又用回到HBuilder，使用纯前端编辑项目。中间来来回回，自己纠结了好几次，不过最终还是拿这个版发布了。
                            <br><br>
                            <img src="images/art/001.jpg" width="680" height="300">
                            <div class="article-detail-sign">
                                <hr class="layui-bg-gray">
                                <p>出自：</p>
                                <p>地址：工1-413</p>
                            </div>
                        </div >
                    </div>
                </div>
                <!--右边小栏目-->
                <div class="blog-main-right">
                	<!--右边悬浮 平板或手机设备显示-->
                    <div class="category-toggle"><i class="fa fa-chevron-left"></i></div>
                	<!-- 分类导航 -->
                	<div class="article-category shadow">
                        <div class="article-category-title">分类导航</div>
                        <a href="javascript:go(1)">杂文随笔</a>
                        <a href="javascript:go(2)">JAVA基础</a>
                        <a href="javascript:go(3)">Web前端</a>
                        <a href="javascript:go(4)">My Sql</a>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <!-- 底部 -->
    <footer class="blog-footer">
        <p><span>Copyright</span><span>&copy;</span><span>2018</span><a href="http://www.lyblogs.cn">RecruitManagement</a></p>
    </footer>
    <!--侧边导航-->
    <ul class="layui-nav layui-nav-tree layui-nav-side blog-nav-left layui-hide" lay-filter="nav">
        <li class="layui-nav-item layui-this">
            <a href="home.html"><i class="fa fa-home fa-fw"></i>&nbsp;招聘信息</a>
        </li>

        <li class="layui-nav-item">
            <a href="resource.ftl"><i class="fa fa-tags fa-fw"></i>&nbsp;个人中心</a>
        </li>
    </ul>

    <!--遮罩-->
    <div class="blog-mask animated layui-hide"></div>
    <!-- layui.js -->
    <script src="${ctx!}/layui/layui.js"></script>
    <!-- 全局脚本 -->
    <script src="${ctx!}/js/global.js"></script>
    <script src="${ctx!}/js/canvas-particle.js"></script>

</body>
</html>