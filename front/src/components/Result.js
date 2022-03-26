import React from 'react'
import { connect } from 'react-redux';

const Result = (props) => {
    console.log(props);
    return (
        <div>
            {props.result && 'Integer numbers generated: ' + props.result} 
        </div>
    )
}

const stateMapToPros = state => {



    return {
        result: state.random.result?.numbersList
    }
}

export default connect(stateMapToPros)(Result)
