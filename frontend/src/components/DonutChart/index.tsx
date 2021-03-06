import React, {useEffect, useState} from 'react';
import Chart from 'react-apexcharts';
import axios from "axios";
import {BASE_URL} from "../../utils/requests";
import {SaleSum} from "../../types/sale";

type CharData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    const [chartData, setChartData] = useState<CharData>({labels: [], series: []});


    useEffect(() => {
        axios.get(`${BASE_URL}/sales/sum-by-seller`)
            .then(response => {
                const data = response.data as SaleSum[];
                const myLabels = data.map(x => x.sellerName);
                const mySeries = data.map(x => x.sum);

                setChartData({labels: myLabels, series: mySeries});

            });
    }, []);


    // Wrong way
    {/*
    let chartData : CharData = {labels: [], series: []};

    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            chartData = { labels: myLabels, series: mySeries};

        });

    */
    }

    {/*
    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }
   */
    }

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{...options, labels: chartData.labels}}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;