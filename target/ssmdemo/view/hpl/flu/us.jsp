<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="../js/echarts-4.3.0.min.js"></script>

</head>
<body>
<div id="main" style="width: 600px;height:600px;"></div>
<script type="text/javascript">
    var area = new Array();
    var index = 0;
    <c:forEach var="list1" items="${area}">
    area[index++] = ${list1};
    </c:forEach>

    var qz = new Array();
    var index1 = 0;
    <c:forEach var="list2" items="${qz}">
    qz[index1++] = ${list2};
    </c:forEach>

    var sw = new Array();
    var index2 = 0;
    <c:forEach var="list3" items="${sw}">
    sw[index2++] = ${list3};
    </c:forEach>
    var myChart = echarts.init(document.getElementById('main'));


    option = {
        title: {
            text: '美国疫情'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow',
                label: {
                    show: true
                }
            }
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        legend: {
            data: ['确诊', '死亡'],
            itemGap: 5
        },
        grid: {
            top: '12%',
            left: '1%',
            right: '10%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: area
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '人数',
                axisLabel: {
                    formatter: function (a) {
                        a = +a;
                        return isFinite(a)
                            ? echarts.format.addCommas(+a / 1000)
                            : '';
                    }
                }
            }
        ],
        dataZoom: [
            {
                show: true,
                start: 94,
                end: 100
            },
            {
                type: 'inside',
                start: 94,
                end: 100
            },
            {
                show: true,
                yAxisIndex: 0,
                filterMode: 'empty',
                width: 30,
                height: '80%',
                showDataShadow: false,
                left: '93%'
            }
        ],
        series: [
            {
                name: '确诊',
                type: 'bar',
                data: qz
            },
            {
                name: '死亡',
                type: 'bar',
                data: sw
            }
        ]
    };

    myChart.setOption(option);


</script>
</body>
</html>