import React, { useState } from 'react'
import { connect } from 'react-redux';
import { fetchRandom } from '../actions';

const From = (props) => {// component stateless
    const [state, setState] = useState({columns: 0, amount: 0, initialNumber: 0, finalNumber: 0});
    const onSubmit = (e) => {
        e.preventDefault();
        props.dispatch(fetchRandom(state));
    };
    return <div className='form'>
        <form className='form-contain' onSubmit={onSubmit}>
            <h3 className='form-subtitle'>Enter the parameters</h3>
            <label className='form-label' htmlFor='amount'>Quantity of numbers:</label>
            <input className='form-input' name='amount' id='amount' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
            <label className='form-label' htmlFor='initialNumber'>Lowest possible number:</label>
            <input className='form-input' name='initialNumber' id='initialNumber' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
            <label className='form-label' htmlFor='finalNumber'>Highest possible number:</label>
            <input className='form-input' name='finalNumber' id='finalNumber' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
            <label className='form-label' htmlFor='columns'>Number of columns to display:</label>
            <input className='form-input' name='columns' id='columns' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
            <button type="submit" disabled={props.loading}>Get numbers</button>
        </form>
    </div>
}


const stateMapToProps = state => {
    return {
        loading: state.view.loading
    }
}


export default connect(stateMapToProps)(From)
