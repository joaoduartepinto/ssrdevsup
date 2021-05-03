import React from 'react';
import NavBar from "./components/NavBar";
import Footer from "./components/Footer";
import DataTable from "./components/DataTable";
import BarChart from "./components/BarChart";
import DonutChart from "./components/DonutChart";

function App() {
    return (
        <>
            <NavBar/>
            <div className="container">
                <h1 className="text-primary">Sales</h1>

                <div className="row px-3">

                    <div className="col-sm-6">
                        <h4 className="text-center text-secondary">Percentage of Sales</h4>
                        <BarChart/>
                    </div>

                    <div className="col-sm-6">
                        <h4 className="text-center text-secondary">Total Sales</h4>
                        <DonutChart/>
                    </div>

                </div>

                <div className="py-3">
                    <h2 className="text-primary">
                        Total Sales
                    </h2>
                </div>


                <DataTable/>
            </div>
            <Footer/>
        </>
    );
}

export default App;
