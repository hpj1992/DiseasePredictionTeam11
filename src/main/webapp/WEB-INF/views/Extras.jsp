<!DOCTYPE html>
<html lang="en">
<head>
    <title>Profile | Details</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/icons/favicon.ico">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/resources/images/icons/favicon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/resources/images/icons/favicon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/resources/images/icons/favicon-114x114.png">
    <!--Loading bootstrap css-->
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,700,300">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/jquery-ui-1.10.4.custom.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/animate.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/main.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/style-responsive.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/zabuto_calendar.min.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/pace.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/jquery.news-ticker.css">
</head>
<body>
    <div>
        <!--BEGIN BACK TO TOP-->
        <a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
        <!--END BACK TO TOP-->
        <!--BEGIN TOPBAR-->
        <div id="header-topbar-option-demo" class="page-header-topbar">
            <nav id="topbar" role="navigation" style="margin-bottom: 0;" data-step="3" class="navbar navbar-default navbar-static-top">
            <div class="navbar-header">
                <button type="button" data-toggle="collapse" data-target=".sidebar-collapse" class="navbar-toggle"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                <a id="logo" href="index.html" class="navbar-brand"><span class="fa fa-rocket"></span><span class="logo-text">HealthCare</span><span style="display: none" class="logo-text-icon">µ</span></a></div>
            <div class="topbar-main"><a id="menu-toggle" href="#" class="hidden-xs"><i class="fa fa-bars"></i></a>
                
                <div class="news-update-box hidden-xs"><span class="text-uppercase mrm pull-left text-white">HealthCare</span>
                    <ul id="news-update" class="ticker list-unstyled">
                        <li>Welcome to HealthCare! We are here just for you! Glad to help you!</li>
                        <li>Please Enter your Gene Data, LifeStyle Data and other Personal details to get all recommendations.</li>
                    </ul>
                </div>
                <ul class="nav navbar navbar-top-links navbar-right mbn">
                    
                    <li class="dropdown topbar-user"><a data-hover="dropdown" href="#" class="dropdown-toggle">&nbsp;<span class="hidden-xs">${username}</span>&nbsp;<span class="caret"></span></a>
                        <ul class="dropdown-menu dropdown-user pull-right">
                            <li><a href="Login.html"><i class="fa fa-key"></i>Log Out</a></li>
                        </ul>
                    </li>
                    
                </ul>
            </div>
        </nav>
        </div>
        <!--END TOPBAR-->
        <div id="wrapper">
            <!--BEGIN SIDEBAR MENU-->
            <nav id="sidebar" role="navigation" data-step="2" data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
                data-position="right" class="navbar-default navbar-static-side">
            <div class="sidebar-collapse menu-scroll">
                <ul id="side-menu" class="nav">
                     <div class="clearfix"></div>
                    <li><a href="dashboard.html"><i class="fa fa-tachometer fa-fw">
                        <div class="icon-bg bg-orange"></div>
                    </i><span class="menu-title">Dashboard</span></a></li>
                    
                    <li><a href="geneGraph.html"><i class="fa fa-edit fa-fw">
                        <div class="icon-bg bg-violet"></div>
                    </i><span class="menu-title">Gene Data Form</span></a>
                      
                    </li>
                    <li><a href="lifestyle.html"><i class="fa fa-edit fa-fw">
                        <div class="icon-bg bg-violet"></div>
                    </i><span class="menu-title">Lifestyle Form</span></a>
                      
                    </li>
                    <!-- <li><a href="Tables.html"><i class="fa fa-th-list fa-fw">
                        <div class="icon-bg bg-blue"></div>
                    </i><span class="menu-title">OverAll Prediction</span></a>
                          
                    </li> -->
                    <li class="active"><a href="Extras.html"><i class="fa fa-user fa-fw">
                        <div class="icon-bg bg-grey"></div>
                    </i><span class="menu-title">Edit Profile</span></a>
                      
                    </li>
                    <li><a href="Charts.html"><i class="fa fa-bar-chart-o fa-fw">
                        <div class="icon-bg bg-orange"></div>
                    </i><span class="menu-title">Risk Factors Chart</span></a>
                </ul>
            </div>
        </nav>
          
          
            <div id="page-wrapper">
                <!--BEGIN TITLE & BREADCRUMB PAGE-->
                <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                    <div class="page-header pull-left">
                        <div class="page-title">
                            Profile</div>
                    </div>
                    <ol class="breadcrumb page-breadcrumb pull-right">
                        <li><i class="fa fa-home"></i>&nbsp;<a href="dashboard.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                        <li class="hidden"><a href="#">Profile</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                        <li class="active">Profile</li>
                    </ol>
                    <div class="clearfix">
                    </div>
                </div>
                <!--END TITLE & BREADCRUMB PAGE-->
                <!--BEGIN CONTENT-->
                <div class="page-content">
                    <div id="tab-general">
                        <div class="row mbl">
                            <div class="col-lg-12">
                                
                                            <div class="col-md-12">
                                                <div id="area-chart-spline" style="width: 100%; height: 300px; display: none;">
                                                </div>
                                            </div>
                                
                            </div>

                            <div class="col-lg-12">
                              
                                    
                              <div class="row">
                    <div class="col-md-12"><h2>Profile: ${username} </h2>

                        <div class="row mtl">
                            
                            <div class="col-md-12">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#tab-edit" data-toggle="tab">Edit Profile</a></li>
                                </ul>
                                <div id="generalTabContent" class="tab-content">
                                    <div id="tab-edit" class="tab-pane fade in active">
                                        <form action="saveUpdatedProfile" method="post" class="form-horizontal"><h3>Account Setting</h3>

                                            <div class="form-group"><label class="col-sm-3 control-label">Email</label>

                                                <div class="col-sm-9 controls">
                                                    <div class="row">
                                                        <div class="col-xs-9"><input type="email" name="email" class="form-control"/></div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <hr/>
                                            <h3>Profile Setting</h3>

                                            <div class="form-group"><label class="col-sm-3 control-label">First Name</label>

                                                <div class="col-sm-9 controls">
                                                    <div class="row">
                                                        <div class="col-xs-9"><input type="text" name="firstName" placeholder="" class="form-control"/></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-3 control-label">Last Name</label>

                                                <div class="col-sm-9 controls">
                                                    <div class="row">
                                                        <div class="col-xs-9"><input type="text" name="lastName" placeholder="" class="form-control"/></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group"><label class="col-sm-3 control-label">Birthday</label>

                                                <div class="col-sm-9 controls">
                                                    <div class="row">
                                                        <div class="col-xs-4"><input id="datepicker-normal" type="date" name="birthDate" class="form-control"/></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr/>
                                            <button type="submit" class="btn btn-green btn-block">Finish</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                              
                                </div>
                                
                            
                     
                            
                        </div>
                    </div>
                </div>
                <!--END CONTENT-->
                <!--BEGIN FOOTER-->
                <div id="footer">
                    <div class="copyright">
                        <a href="http://themifycloud.com">2014 © KAdmin Responsive Multi-Purpose Template</a></div>
                </div>
                <!--END FOOTER-->
            </div>
            <!--END PAGE WRAPPER-->
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/resources/script/jquery-1.10.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery-migrate-1.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/bootstrap-hover-dropdown.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/respond.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.slimscroll.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/icheck.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/custom.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.news-ticker.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.menu.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/pace.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/holder.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/responsive-tabs.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.flot.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.flot.categories.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.flot.pie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.flot.tooltip.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.flot.resize.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.flot.fillbetween.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.flot.stack.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/jquery.flot.spline.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/zabuto_calendar.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/script/index.js"></script>
    <!--LOADING SCRIPTS FOR CHARTS-->
    <script src="${pageContext.request.contextPath}/resources/script/highcharts.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/data.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/drilldown.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/exporting.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/highcharts-more.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/charts-highchart-pie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/script/charts-highchart-more.js"></script>
    <!--CORE JAVASCRIPT-->
    <script src="${pageContext.request.contextPath}/resources/script/main.js"></script>
    <script>        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
            m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-145464-12', 'auto');
        ga('send', 'pageview');


</script>
</body>
</html>
