<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>双色球中奖结果通知</title>
    <meta name="format-detection" content="telephone=no" />
    <style type="text/css">
        body {
            text-align: center;
        }

        div.table {
            width: 400px;
            border: 1px solid #e3e3e3;
            margin: 0px auto;
            padding: 5px;
            border-radius: 5px;
            text-align: left;
        }
        div.row {
            margin: 8px auto;
        }
        div.row.datetime {
            font-size: small;
        }
        div.row.small {
            font-size: small;
        }

        div.ball {
            width: 30px;
            height: 30px;
            position: relative;
            border: 3px solid #ccc;
            border-radius: 30px;
            text-align: center;
            line-height: 30px;
            display: inline-block;
            font-weight: bold;
        }

        div.ball.red {
            border-color: red;
            color: red;
            text-decoration: none;
        }

        div.ball.blue {
            border-color: blue;
            color: blue;
            text-decoration: none;
        }

        div.ball span {
            margin: 2px auto;
        }
        div a{
            text-underline: none;
            text-decoration: none;
        }
    </style>


</head>
<body>
<h3>亲! 今天的双色球中奖结果</h3>
<div class="table">
    <div class="row datetime"><b>第 ${ball.issueNo} 期开奖结果 </b><br>开奖日期：${calendarUtil.formatDateTime(ball.issueDate,"yyyy-MM-dd HH:mm:ss")}</div>
    <div class="row">
        <div class="ball red"><span>${ball.redball1}</span></div>
        <div class="ball red"><span>${ball.redball2}</span></div>
        <div class="ball red"><span>${ball.redball3}</span></div>
        <div class="ball red"><span>${ball.redball4}</span></div>
        <div class="ball red"><span>${ball.redball5}</span></div>
        <div class="ball red"><span>${ball.redball6}</span></div>&nbsp;&nbsp;
        <div class="ball blue"><span>${ball.blueball1}</span></div>
    </div>
    <div class="row small">
        本期一等奖：${ball.firstPrize?string(',###.00')}&nbsp;元
    </div>
    <div class="row small">
        奖金池：${ball.prizePool?string(',###.00')}&nbsp;元
    </div>
    <div class="row small">
        本期销售总额：${ball.sellAmt?string(',###.00')}&nbsp;元
    </div>
    <div class="row small">
        <a href="https://www.letcode.cn" target="_blank">欢迎大家学习共享！！</a>
    </div>
</div>


</body>
</html>
