import React, { Fragment } from 'react'
import { connect } from 'react-redux';

const Result = (props) => {
    const orderedNumbers = props.result?.numbersList?.map((value, i = 1) => {
        if((i+1) % props.result?.columns == 0) { //Si el index del array es múltiplo de la cantidad de columnas
            return (
                <Fragment key={i}>
                    <div className='number'><span>{value}</span></div>
                    <br/>
                </Fragment>
            );
        }
        return (<div className='number' key={i}><span>{value}</span></div>);
    })
    return <div className='result'>
        <h3 className='form-subtitle'>Generated numbers</h3>
        <div className='container-orderedNumbers'>
            {orderedNumbers}
        </div>
    </div>
}

const stateMapToProps = state => {
    return {
        columns: state.random.result?.columns,
        result: state.random.result
    }
}

export default connect(stateMapToProps)(Result)
