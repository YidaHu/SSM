/*
 * @Author: Huyd
 * @Date:   2017-09-09 22:22:36
 * @Last Modified by:   Huyd
 * @Last Modified time: 2017-09-27 16:13:05
 */

$(function() {
    $('#button').click(function() {
        /* Act on the event */
        $.ajax({
            url: 'http://localhost:8081/SpringMVCRestfulRedis/test/etdata',
            type: 'GET',
            dataType: 'json',
            async: true,
            crossDomain: true,
            success: function(data) {

                var str = '';
                var arr = [];
                // var obj = $.parseJSON(data);
                for (var i = 0; i < data.length; i++) {
                    var test = 1;

                    for (var key in data[i]) {
                        // alert(key+':'+data[i][key]);
                        str = str + key + ':' + data[i][key] + '  ';
                        if (key == 'age') {
                            arr.push(data[i][key]);
                        };
                    }
                }
                alert(arr);
                $('#txtHint').text(str);
                // alert('123');
                console.log(data);
            },
            error: function() {
                /* Act on the event */
                alert('数据获取错误！');
            },
        });

        $.ajax({
            url: 'http://localhost:8081/SpringMVCRestfulRedis/book/list',
            type: 'GET',
            dataType: 'json',
            async: true,
            crossDomain: true,
            success: function(data) {

                var str = '';
                var arr = [];
                // var obj = $.parseJSON(data);
                for (var i = 0; i < data.length; i++) {
                    var test = 1;

                    for (var key in data[i]) {
                        // alert(key+':'+data[i][key]);
                        str = str + key + ':' + data[i][key] + '  ';
                        if (key == 'name') {
                            arr.push(data[i][key]);
                        };
                    }
                }
                alert(arr);
                alert(data);

                $('#txtBook').text(str);
                alert('123');
                console.log(data.toString);
            },
            error: function() {
                /* Act on the event */
                alert('数据获取错误！');
            },
        })
    });


});

// });