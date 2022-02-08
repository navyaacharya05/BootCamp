import axios from 'axios'

//const url="http://localhost:8081/DlitheJavaBootCamp/rest"
const url="http://localhost:8080/DlitheJavaBootCamp-0.0.1-SNAPSHOT/rest"

/// axios.method(url,object)

const append=async(obj)=>{
    const ack = await axios.post(`${url}/new`,obj)
    return ack
}

const traverse=async()=>{
    const tmp=await axios.get(`${url}/`)
    return tmp
}

const oneAtTime=async(param)=>{
    const tmp = await axios.get(`${url}/${param}`)
    return tmp
}

//delete module
const terminate=async(param)=>{
    const t = await axios.delete(`${url}/remove/${param}`)
    return t
}

//update module
const change=async(object)=>{
    const t = await axios.put(`${url}/up`,object)
    return t
}

export {append, traverse, oneAtTime, terminate, change}