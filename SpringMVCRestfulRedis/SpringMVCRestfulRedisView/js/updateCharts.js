/*
 * @Author: Huyd
 * @Date:   2017-09-24 18:19:40
 * @Last Modified by:   Huyd
 * @Last Modified time: 2017-09-25 17:53:14
 */

$(function() {
    $('#update').click(function() {
        /* Act on the event */

        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });

        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function(ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main'));

                var option = {
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data: ['成绩']
                    },
                    xAxis: [{
                        type: 'category',
                        data: []
                    }],
                    yAxis: [{}],
                    series: [{
                        "name": "成绩",
                        "type": "bar",
                        "data": []
                    }]
                };

                myChart.showLoading(); //数据加载完之前先显示一段简单的loading动画


                $.ajax({
                    url: 'http://localhost:3000/post',
                    type: 'GET',
                    dataType: 'json',
                    async: true,
                    crossDomain: true,
                    success: function(data) {
                        var names = []; //姓名数组（实际用来盛放X轴坐标值）
                        var grades = []; //成绩数组（实际用来盛放Y坐标值）
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        // alert(data + "111");
                        var str = "";
                        if (data) {
                            var dataObj = data;
                            $.each(dataObj.post, function(index, val) {
                                /* iterate through array or object */
                                names.push(val.name);
                                // grades.push(val.grade.toString);
                                grades.push(parseInt(val.grade));
                            });

                            // alert(names);
                            // console.log(grades);

                            myChart.hideLoading(); //隐藏加载动画
                            myChart.setOption({ //加载数据图表
                                color: ['#3398DB'],
                                tooltip: {
                                    show: true
                                },
                                legend: {
                                    data: ['成绩']
                                },
                                xAxis: {
                                    data: names
                                },
                                yAxis: {
                                    type: 'value'
                                },

                                series: [{
                                    // 根据名字对应到相应的系列
                                    name: '销量',
                                    type: 'bar',
                                    barWidth: 70,
                                    data: grades
                                }]
                            });
                            // alert('123');
                            // console.log(data);
                        }
                    },
                    error: function() {
                        /* Act on the event */
                        alert('数据获取错误！');
                    },
                });

                // 为echarts对象加载数据
                myChart.setOption(option);


                /*饼状图*/
                // 基于准备好的dom，初始化echarts图表
                var pieCharts = ec.init(document.getElementById('lineChart'));

                var option = {
                    title: {
                        text: '某站点用户访问来源',
                        subtext: '纯属虚构',
                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        x: 'left',
                        data: []
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {
                                show: true
                            },
                            dataView: {
                                show: true,
                                readOnly: false
                            },
                            magicType: {
                                show: true,
                                type: ['pie', 'funnel'],
                                option: {
                                    funnel: {
                                        x: '25%',
                                        width: '50%',
                                        funnelAlign: 'left',
                                        max: 1548
                                    }
                                }
                            },
                            restore: {
                                show: true
                            },
                            saveAsImage: {
                                show: true
                            }
                        }
                    },
                    calculable: true,
                    series: [{
                        name: '及格率',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: []
                    }]
                };

                pieCharts.showLoading(); //数据加载完之前先显示一段简单的loading动画

                $.ajax({
                    url: 'http://localhost:3000/getPass',
                    type: 'GET',
                    dataType: 'json',
                    async: true,
                    crossDomain: true,
                    success: function(data) {
                        var names = []; //姓名数组（实际用来盛放X轴坐标值）
                        var counts = []; //成绩数组（实际用来盛放Y坐标值）
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        // alert(data + "111");
                        var str = "";
                        if (data) {
                            var dataObj = data;
                            var arrays = [];
                            $.each(dataObj.pass, function(index, val) {
                                /* iterate through array or object */
                                names.push(val.name);
                                // grades.push(val.grade.toString);
                                counts.push(val.count);

                            });

                            // alert(arrays);
                            // console.log(grades);

                            pieCharts.hideLoading(); //隐藏加载动画
                            pieCharts.setOption({ //加载数据图表
                                title: {
                                    text: '学生及格率',
                                    subtext: '成绩分析',
                                    x: 'center'
                                },
                                tooltip: {
                                    trigger: 'item',
                                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                                },
                                legend: {
                                    orient: 'vertical',
                                    x: 'left',
                                    data: names
                                },
                                toolbox: {
                                    show: true,
                                    feature: {
                                        mark: {
                                            show: true
                                        },
                                        dataView: {
                                            show: true,
                                            readOnly: false
                                        },
                                        magicType: {
                                            show: true,
                                            type: ['pie', 'funnel'],
                                            option: {
                                                funnel: {
                                                    x: '25%',
                                                    width: '50%',
                                                    funnelAlign: 'left',
                                                    max: 1548
                                                }
                                            }
                                        },
                                        restore: {
                                            show: true
                                        },
                                        saveAsImage: {
                                            show: true
                                        }
                                    }
                                },
                                calculable: true,
                                series: [{
                                    name: '及格率',
                                    type: 'pie',
                                    radius: '55%',
                                    center: ['50%', '60%'],
                                    data: (function() {
                                        var res = [];
                                        var len = names.length;
                                        while (len--) {
                                            res.push({
                                                name: names[len],
                                                value: counts[len]
                                            });
                                        }
                                        return res;
                                    })(),
                                }]

                            });
                        }
                    },
                    error: function() {
                        /* Act on the event */
                        alert('数据获取错误！');
                    },
                });

                // 为echarts对象加载数据
                pieCharts.setOption(option);

            });

    });

});