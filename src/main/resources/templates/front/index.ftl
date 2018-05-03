﻿<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>大学生招聘网站</title>
    <link rel="shortcut icon" href="${ctx!}/images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${ctx!}/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet" />
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${ctx!}/css/index.css" rel="stylesheet" />
</head>
<body>
    <!-- 导航 -->
    <nav class="blog-nav layui-header">
        <div class="blog-container">
            <!-- 用户登陆 -->

			<a class="blog-logo" href="/">大学生招聘网站</a>
            <!-- 导航菜单 -->
            <div class="blog-user"></div>

			<ul class="layui-nav" lay-filter="nav">
				<li class="layui-nav-item layui-this">
					<a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;招聘信息</a>
				</li>

				<li class="layui-nav-item">
					<a href="/user/index"><i class="fa fa-tags fa-fw"></i>&nbsp;个人中心</a>
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
    	<div class="layui-carousel blog-bg" id="carousel">
		  <div carousel-item>
		    <div class="bg bg_a"></div>
		    <div class="bg bg_b"></div>
		    <div class="bg bg_c"></div>
		    <div class="bg bg_d"></div>
		    <div class="bg bg_e"></div>
		  </div>
		</div>
        <div class="blog-container">
            <div class="blog-main">
                <!-- 网站公告提示 -->
                <div class="home-tips shadow">
                    <i style="float:left;line-height:17px;" class="fa fa-volume-up"></i>
                    <div class="home-tips-container">
                        <span style="color: #009688">有事做有所期待，日子就是幸福的</span>
                        <span style="color: #009688">用心每一天，不忘初心，方能走远</span>
                        <span style="color: #009688">偷偷挤进一缕斜阳，送来满满幸福</span>
                    </div>
                </div>
                <!--左边文章列表-->
                <div class="blog-main-left animated slideInLeft">
					<@jobList>
						<#list list as x>
							<div class="article shadow animated fadeInLeft">
                                <div class="article-left ">
                                    <img src="${ctx!}/images/01.jpg" alt="${x.name}"/>
                                </div>

                                <div class="article-right">
                                    <div class="article-title">
                                        <a href="/job/${x.id}">职位名称：${x.name}</a>
                                    </div>
                                    <div class="article-abstract">
                                        公司名称：${x.college.name}
                                    </div>
                                    <div class="article-abstract">
                                        薪资：${x.treatment}/月
                                    </div>
                                    <div class="article-abstract">
                                        地点：${x.location}
                                    </div>
                                </div>
                                <div class="clear"></div>
                                <div class="article-footer">
                                    <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;${x.createTime}</span>
                                    <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;${x.title}</span>
                                    <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">${x.experience}</a></span>
                                    <!--<span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;0</span>-->
                                    <!--<span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;4</span>-->
                                </div>
                            </div>
						</#list>
					</@jobList>
                </div>
                <!--右边小栏目-->
                <div class="blog-main-right">
                	<!-- 小编信息 -->
                    <div class="blogerinfo shadow animated fadeInRight">
                        <div class="blogerinfo-figure">
                            <img src="${ctx!}/images/login.png" alt="Absolutely" />
                        </div>
                        <p class="blogerinfo-nickname"></p>
                        <p class="blogerinfo-introduce">一枚90后程序员，java开发工程师</p>
                        <p class="blogerinfo-location"><i class="fa fa-location-arrow"></i>&nbsp;中国 - 北京</p>
                        <hr />
                    </div>
                    <!--推荐/点击排行-->
					<div class="layui-tab layui-tab-brief shadow animated fadeInRight" lay-filter="docDemoTabBrief">
						<ul class="layui-tab-title">
							<li class="layui-this">点击排行</li>
							<!--<li>站长推荐</li>-->
						</ul>
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
								<ul class="blog-module-ul">
									<li><i class="layui-badge-rim layui-bg-red">1</i>&nbsp;&nbsp;<a href="detail.ftl?aid=0001"><i class="layui-icon">&#xe609;</i>Java开发工程师</a></li>
									<li><i class="layui-badge-rim layui-bg-orange">2</i>&nbsp;&nbsp;<a href="detail.ftl?aid=0005">高级php开发工程师</a></li>
									<li><i class="layui-badge-rim layui-bg-green">3</i>&nbsp;&nbsp;<a href="detail.ftl?aid=0003">c#软件工程师!</a></li>
									<li><i class="layui-badge-rim">4</i>&nbsp;&nbsp;<a href="detail.ftl?aid=0004">办公室文员</a></li>
									<li><i class="layui-badge-rim">5</i>&nbsp;&nbsp;<a href="detail.ftl?aid=0004">销售总监/经理</a></li>
								</ul>
							</div>
						</div>
					</div>

					<div class="blog-module shadow">
						<div class="blog-module-title">友情链接</div>
						<ul class="blogroll">
							<li><a target="_blank" href="http://www.layui.com/" title="Layui">Layui</a></li>
							<li><a target="_blank" href="http://www.pagemark.cn/" title="页签">页签</a></li>
						</ul>
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
			<a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;招聘信息</a>
		</li>

		<li class="layui-nav-item">
			<a href="/user/index"><i class="fa fa-tags fa-fw"></i>&nbsp;个人中心</a>
		</li>
    </ul>

    <!--遮罩-->
    <div class="blog-mask animated layui-hide"></div>
    <!-- layui.js -->
    <script src="${ctx!}/layui/layui.js"></script>
    <!-- 全局脚本 -->
    <script src="${ctx!}/js/global.js"></script>
    <script src="${ctx!}/js/canvas-particle.js"></script>
    <!-- 本页脚本 -->
    <script src="${ctx!}/js/index.js"></script>
</body>
</html>