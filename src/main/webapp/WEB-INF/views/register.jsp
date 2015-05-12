<!DOCTYPE html>
<html lang="en">
<head>
    <title>Forms | Forms</title>
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
                                    
                                    
										
                                        <div class="panel panel-orange">
                                            <div class="panel-heading">
                                                Registration form</div>
                                            <div class="panel-body pan">
                                                <form action="signUp" method="post">
                                                <div class="form-body pal">
                                                    <div class="form-group">
                                                        <div class="input-icon right">
                                                            <i class="fa fa-envelope"></i>
                                                            <input id="email" name="email" type="text" placeholder="Email address" class="form-control" /></div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="input-icon right">
                                                            <i class="fa fa-lock"></i>
                                                            <input id="password" name="password" type="password" placeholder="Password" class="form-control" /></div>
                                                    </div>
                                                    <!-- <div class="form-group">
                                                        <div class="input-icon right">
                                                            <i class="fa fa-lock"></i>
                                                            <input id="inputConfirmPassword" name="confirmPassword" type="password" placeholder="Confirm Password" class="form-control" /></div>
                                                    </div> -->
                                                    <hr />
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                            <div class="input-icon right">
                                                            <i class="fa fa-user"></i>
                                                                <input id="inputFirstName" name="firstName" type="text" placeholder="First Name" class="form-control" /></div>
                                                        </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                            <div class="input-icon right">
                                                            <i class="fa fa-user"></i>
                                                                <input id="inputLastName" name="lastName" type="text" placeholder="Last Name" class="form-control" /></div>
                                                        </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <input id="birthDate" type="date" name="birthDate" placeholder="Date of Birth" class="form-control" /></div>
                                                         </div>     
                                                         <div class="col-md-6">
                                                            <div class="form-group">   
                                                                <select name="gender" class="form-control">
                                                            <option>Gender</option>
                                                            <option value="male">Male</option>
                                                            <option value="female">Female</option>
                                                            <option value="other">Other</option>
                                                        </select>
                                                       </div>
                                                    </div>
                                                    
                                                    
                                                    
                                                </div>
                                                <div class="form-actions text-right pal">
                                                    <button type="submit" class="btn btn-primary">
                                                        Submit</button>
                                                </div>
                                                </div>
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
                <!--END CONTENT-->
                <!--BEGIN FOOTER-->
                <div id="footer">
                    <div class="copyright">
                        2015 © Team 11</a></div>
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
