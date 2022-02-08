import React, { useState } from "react";
import TextField from '@mui/material/TextField';
import InputAdornment from '@mui/material/InputAdornment';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import Button from '@mui/material/Button';
import AddCircleIcon from '@mui/icons-material/AddCircle';
import RotateLeftIcon from '@mui/icons-material/RotateLeft';
import { append } from "./API";
//import { putting } from "./DataAccess";

const Create=()=>{

    const[data,setDate]=useState(
        {
            "org":"",
            "locations":[],
            "employees":0,
            "basic":0.0,
            "services":[],
            "benchmarks":[]
        }
    )

    const perform=(eve)=>{
        // extraction
        const{name,value}=eve.target;
        setDate((old)=>{
            return{
                ...old,
                [name]:value
            }
        })
    }

    const adding=async()=>{

        // replacing simple text with , to list of text by , as delimiter
        data.locations=data.locations.split(',')
        data.services=data.services.split(',')
        data.benchmarks=data.benchmarks.split(',')

        alert(JSON.stringify(data))
        //putting(data)
        const yet=await append(data) // data: json of corporate
        alert(yet.data)
        // yet.data >> response keyword from back end which recieved by yet variable via axios
    }

    return(
        <>
            <div className="mt-4 container">
                <h1 className="display-2 text-center text-info">Enroll New Corporate</h1>
                <div className="row justify-content-center">
                    <div className="col-lg-6 col-md-8 col-sm-12 shadow-lg p-3">
                        <TextField
                        required
                        id="outlined-required"
                        label="Organization name"
                        onChange={perform}
                        name="org"
                        value={data.org}
                        className="form-control mb-3"
                        />
                        <TextField
                        required
                        id="outlined-required"
                        label="Organization location"
                        onChange={perform}
                        name="locations"
                        value={data.locations}
                        className="form-control mb-3"
                        />
                        <InputLabel htmlFor="outlined-adornment-amount">Organizarion employees count</InputLabel>
                        <OutlinedInput
                            id="outlined-adornment-amount"
                            startAdornment={<InputAdornment position="start">#</InputAdornment>}
                            className="form-control mb-3"
                            onChange={perform}
                            name="employees"
                            value={data.employees}
                        />
                        <TextField
                        label="Organization basic salary"
                        id="outlined-start-salary"
                        startAdornment= {<InputAdornment position="start">Per/Annum</InputAdornment>}
                        className="form-control mb-3"
                        onChange={perform}
                        name="basic"
                        value={data.basic}
                        />
                        <InputLabel htmlFor="outlined-adornment-services">Organizarion services</InputLabel>
                        <OutlinedInput
                            id="outlined-adornment-services"
                            className="form-control mb-3"
                            onChange={perform}
                            name="services"
                            value={data.services}
                        />
                        <InputLabel htmlFor="outlined-adornment-bench">Organizarion best apps</InputLabel>
                        <OutlinedInput
                            id="outlined-adornment-bench"
                            className="form-control mb-3"
                            onChange={perform}
                            name="benchmarks"
                            value={data.benchmarks}
                        />
                        <div className="row justify-content-around">
                            <Button variant="outlined" color="primary" className="col-4" onClick={adding}>
                                <AddCircleIcon/>
                            </Button>
                            <Button variant="outlined" color="error" className="col-4">
                                <RotateLeftIcon/>
                            </Button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Create;