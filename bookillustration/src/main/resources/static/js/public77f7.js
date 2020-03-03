$(function () {
    var user_info_timer = null;
    $(".menu-fr").children(".user-info").children(".avatar, .hide-box,.hide-bar").mouseover(function () {
        clearTimeout(user_info_timer);
        $(".hide-bar, .hide-box").show();
    });
    $(".menu-fr").children(".user-info").children(".avatar, .hide-box,.hide-bar").mouseout(function () {
        user_info_timer = setTimeout(function () {
            $(".hide-bar, .hide-box").hide()
        }, 200);
    });
    $(".hide-bar li").mouseover(function () {
        $(this).addClass("on").siblings().removeClass("on");
    })
    $(".hide-bar li").mouseout(function () {
        $(".hide-bar li").first().addClass("on").siblings().removeClass("on");
    })
})
// var console={};
// console.log=function(){};
function look_all(k) {
    for(var i=1;i<=k;i++){
        $("#adds_"+i+"").attr("style","display:block;max-height:654px;");
        $("#count_"+i+"").attr("style","display:block;");
    }
    $("#btn_all").attr("style","display:none;");
}

function look_comments(k) {
    for(var i=1;i<=k;i++){
        $("#comment_"+i+"").attr("style","display:block;");
    }
    $("#commentBtn_all").attr("style","display:none;");

}
function is_rgb_similar(v1, v2) {
    var b1 = v1 & 0x0000ff;
    var g1 = (v1 & 0x00ff00) / 256;
    var r1 = (v1 & 0xff0000) / 256 / 256;
    var b2 = v2 & 0x0000ff;
    var g2 = (v2 & 0x00ff00) / 256;
    var r2 = (v2 & 0xff0000) / 256 / 256;
    if ((r1 - r2) * (r1 - r2) + (g1 - g2) * (g1 - g2) + (b1 - b2) * (b1 - b2) < 10)
        return true;
    return false;
}

//rgb转16进制
var colorHex = function (color) {
    var that = color;
    //十六进制颜色值的正则表达式
    var reg = /^#([0-9a-fA-f]{3}|[0-9a-fA-f]{6})$/;
    // 如果是rgb颜色表示
    if (/^(rgb|RGB)/.test(that)) {
        var aColor = that.replace(/(?:\(|\)|rgb|RGB)*/g, "").split(",");
        var strHex = "#";
        for (var i = 0; i < aColor.length; i++) {
            var hex = Number(aColor[i]).toString(16);
            if (hex.length < 2) {
                hex = '0' + hex;
            }
            strHex += hex;
        }
        if (strHex.length !== 7) {
            strHex = that;
        }
        return strHex;
    } else if (reg.test(that)) {
        var aNum = that.replace(/#/, "").split("");
        if (aNum.length === 6) {
            return that;
        } else if (aNum.length === 3) {
            var numHex = "#";
            for (var i = 0; i < aNum.length; i += 1) {
                numHex += (aNum[i] + aNum[i]);
            }
            return numHex;
        }
    }
    return that;
};

//login
function alert_login() {
    $(".regsiter-eject").hide();
    $(".shade").hide();
    var th = ($(window).height() - 565) / 2;
    var rw = ($(window).width() - 365) / 2;
    if (rw < 0) {
        rw = (365 - $(window).width()) / 4;
    }
    $(".login-eject").css({
        left: rw, top: th, display: "block", width: 335, height: 535
    });
    $(".shade").show();
}

function show_all_pic() {
    $(".works-ul").children(".works-show").show();
    $(".show_more").remove();
}

function alert_register() {
    $(".login-eject").hide();
    $(".shade").hide();
    var th = ($(window).height() - 565) / 2;
    var rw = ($(window).width() - 365) / 2;
    if (rw < 0) {
        rw = (365 - $(window).width()) / 4;
    }
    $(".regsiter-eject").css({
        left: rw, top: th, display: "block", width: 335, height: 535
    });
    $(".shade").show();
}

//public
function alert_public() {
    var th = ($(window).height() - 300) / 2;
    var rw = ($(window).width() - 400) / 2;
    if (rw < 0) {
        rw = (400 - $(window).width()) / 4;
    }
    $(".public-eject").css({
        left: rw, top: th, display: "block", width: 400, height: 300
    });
    $(".shade").show();
}

function close_alert_public() {
    $(".public-eject").hide();
    $(".shade").hide();
}

function show_ad(url, aId) {
    $.ajax({
        type: 'GET',
        url: url,
        cache: false,
        data: {'aId': aId, '_token': _token},
        dataType: 'json',
        success: function (data) {

        },
        error: function (xhr, status, error) {

        }
    })
}

$(document).ready(function () {
    //返回顶部
    $(window).on('scroll resize', function () {
        if ($(document).scrollTop() > 200) {
            $(".homeup").show();
        } else {
            $(".homeup").hide();
        }
    });
    $('.homeup').click(function () {
        $('html,body').animate({scrollTop: 0}, 'slow');
    });

    $(".coin-title a").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
    })

    $(".shade,.regsiter-eject .close, .login-eject .close, .novel-eject .close").click(function () {
        $(".eject,.public-eject,.login-eject,.regsiter-eject, .novel-eject").css({
            display: "none"
        });
        $(".shade").hide();
    });


    $(".ajax_login_submit").click(function () {
            var data = $("#ajax_login").serialize();
        var url = $("#ajax_login").attr("action");
        var mobile = $("#ajax_login input[ name='mobile' ] ");
        if ($("#ajax_login input[ name='mobile' ] ").val() && $("#ajax_login input[ name='password' ] ").val()) {
            $.ajax({
                type: 'POST',
                url: url,
                cache: false,
                data: data,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 1) {
                        window.location.reload()
                    }
                },
                error: function (xhr, status, error) {
                    mobile.nextAll(".tips-error").remove();
                    if (xhr.responseJSON.errors['mobile']) {
                        mobile.after('<span class="tips-error">' + xhr.responseJSON.errors['mobile'][0] + '</span>');
                    }
                }
            })
        }

    })
    $(".ajax_register_submit").click(function () {
        var data = $("#ajax_register").serialize();
        var url = $("#ajax_register").attr("action");
        var username = $("#ajax_register input[ name='username' ] ");

        if ($("#ajax_register input[ name='username' ] ").val() && $("#ajax_register input[ name='mobile' ] ").val() && $("#ajax_register input[ name='password' ] ").val()) {
            $.ajax({
                type: 'POST',
                url: url,
                cache: false,
                data: data,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 1) {
                        window.location.reload()
                    }
                },
                error: function (xhr, status, error) {
                    username.nextAll(".tips-error").remove();
                    if (xhr.responseJSON.errors['mobile']) {
                        username.after('<span class="tips-error">注册失败，请稍后再试 !</span>');
                    }
                }
            })
        }
    })

    $(".ajax_logout_submit").click(function () {
        var data = $("#ajax_logout").serialize();
        var url = $("#ajax_logout").attr("action");
        if ($("#ajax_logout input[ name='_token' ] ").val()) {
            $.ajax({
                type: 'POST',
                url: url,
                cache: false,
                data: data,
                dataType: 'json',
                success: function (data) {
                    if (data.code == 1) {
                        window.location.reload()
                    }
                },
                error: function () {
                }
            })
        }
    })
});

// layui
// layui.use('form', function () {
//     var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
//     //
//     // //……
//     // //但是，如果你的HTML是动态生成的，自动渲染就会失效
//     // //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
//     // form.render();
// });
//删除标签
$("#tags").on('click', '.delete', function (event) {
    event.stopPropagation();
    document.getElementsByClassName("count")[0].innerHTML = parseInt(document.getElementsByClassName("count")[0].innerText) - 1;
    document.getElementById("r" + $(this).parent().attr('id')).classList.remove('selected');
    console.log('has been click');
    $(this).parent().remove();
});
//添加标签
$("#rtags").on('click', '.update', function () {
    var length = $(this).attr('id').length;
    var tag = $(this).attr('id');
    var number = $(this).attr('id').substring(2, length).replace(/[^0-9]/ig, "");
    if (document.getElementById("tag_" + number) == null) {
        if (document.getElementById("tags").getElementsByTagName('li').length < 10) {
            document.getElementById("tags").innerHTML += " <li id='tag_" + number + "'>\n" +
                "                                <span class='_icon-text delete'>" + document.getElementById(tag).innerText + "</span>\n" +
                "                                <input name='label' type='hidden' value='" + document.getElementById(tag).innerText + "' />\n" +
                "                            </li>";
            document.getElementsByClassName("count")[0].innerHTML = parseInt(document.getElementsByClassName("count")[0].innerText) + 1;
            if (document.getElementById("tags").getElementsByTagName('li').length >= 10) {
                document.getElementsByClassName("tencount")[0].innerText = "标签最多10人";
            }

            document.getElementById($(this).attr('id')).classList.add('selected');

        }
    } else {
        document.getElementsByClassName("count")[0].innerHTML = parseInt(document.getElementsByClassName("count")[0].innerText) - 1;
        document.getElementsByClassName("tencount")[0].innerText = "";
        document.getElementById('tag_' + number).remove();
        document.getElementById(tag).classList.remove('selected');

    }
    console.log('has been click');
});

function taginput(event) {
    if (event.keyCode == 13) {
        // 触发需要调用的方法
        var update=document.getElementsByClassName("update");
        var tag = document.getElementsByClassName("atlas")[0];
        var oli=document.getElementById("tags").getElementsByTagName("li");
        for(var i=0;i<oli.length;i++){
            if(oli[i].innerText==tag.value){
                tag.value = ""
                return false;
            }
        }
        for (var i=0;i<update.length-1;i++){
            if(update[i].innerText==tag.value){
                var e = document.createEvent("MouseEvents");
                e.initEvent("click", true, true);
                update[i].dispatchEvent(e);
                tag.value = ""
                return false;
            }
        }

        if (oli.length < 10) {
            var number = 20;
            for (var i = 20; i < 31; i++) {
                if (document.getElementById("tag_" + i) == null) {
                    number = i;
                    break;
                }
            }
            if (tag.value.length != 0) {
                document.getElementsByClassName("tencount")[0].innerText = "";
                document.getElementsByClassName("count")[0].innerHTML = parseInt(document.getElementsByClassName("count")[0].innerText) + 1;
                document.getElementById("tags").innerHTML += " <li id='tag_" + number + "'>\n" +
                    "                                                        <span class='_icon-text delete'>" + tag.value + "</span> \n" +
                    "                                                       <input name='label' type='hidden' value='" + tag.value + "' />\n" +
                    "                                                   </li>"
                tag.value = "";
            } else {
                document.getElementsByClassName("tencount")[0].innerText = "标签填写时不得为空";
            }
            if (oli.length >= 10) {
                document.getElementsByClassName("tencount")[0].innerText = "标签最多10人";
            }
        }
        return false;
    }
}
//当前端改变时触发
function  avatarfile(file) {
    var filextension =file.value.substring(file.value.lastIndexOf("."), file.value.length);
    if((filextension != '.jpg') && (filextension != '.gif')  && (filextension != '.png')){
        alert("上传的格式错误");
    }else{
        var imagefile=document.getElementById("avatar_image");

        preImg(file,imagefile.getElementsByTagName("img"));
    }
}
//返回当前图片地址
function getFileUrl(file) {
    var url;
    var agent = navigator.userAgent;
    if (agent.indexOf("MSIE")>=1) {
        url = file.value;
    } else if(agent.indexOf("Firefox")>0) {
        url = window.URL.createObjectURL(file.files.item(0));
    } else if(agent.indexOf("Chrome")>0) {
        url = window.URL.createObjectURL(file.files.item(0));
    }
    return url;
}
//读取图片后预览
function preImg(fileId,imgId) {
    imgId[imgId.length-1].src = getFileUrl(fileId);
}
$(function(){

    $('input:not([autocomplete]),textarea:not([autocomplete]),select:not([autocomplete])').attr('autocomplete', 'off');

}); 
