<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/4
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图标</title>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<div id="main1" style="width: 600px;height:400px;"></div>
<script src="../../../js/echarts-4.3.0.min.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '中国疫情'
        },
        tooltip: {},
        legend: {
            data:['人数']
        },
        xAxis: {
            data: ["现存确诊","现存疑似","现存重症","累计确诊","累计治愈","累计死亡"]
        },
        yAxis: {},
        series: [{
            name: '人数',
            type: 'bar',
            data: ['${xq}', '${xy}','${xz}','${lq}', '${lz}','${ls}']
        }]
    };

    var myChart1 = echarts.init(document.getElementById('main1'));
    var option1 = {
        title: {
            text: '美国疫情'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            top: '5%',
            left: 'center'
        },
        series: [
            {
                name: '人数',
                type: 'pie',
                radius: ['40%', '70%'],
                avoidLabelOverlap: false,
                itemStyle: {
                    borderRadius: 10,
                    borderColor: '#fff',
                    borderWidth: 2
                },
                label: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    label: {
                        show: true,
                        fontSize: '40',
                        fontWeight: 'bold'
                    }
                },
                labelLine: {
                    show: false
                },
                data: [
                    {value: '${mlq}', name: '累计确诊'},
                    {value: '${msw}', name: '死亡'},
                    {value: '${mzy}', name: '治愈'},
                ]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart1.setOption(option1);
</script>
</body>
</html>
