import React, { useState } from 'react'
import { connect } from 'react-redux';
import { fetchRandom } from '../actions';

const From = (props) => {// component stateless
    const [state, setState] = useState({columns: 0, amount: 0, initialNumber: 0, finalNumber: 0});
    const onSubmit = (e) => {
        e.preventDefault();
        props.dispatch(fetchRandom(state));
    };
    return <div>
        <form onSubmit={onSubmit}>
            <label htmlFor='amount'>Cantidad de números:</label>
            <input name='amount' id='amount' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
            <label htmlFor='initialNumber'>Menor número posible:</label>
            <input name='initialNumber' id='initialNumber' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
            <label htmlFor='finalNumber'>Mayor número posible:</label>
            <input name='finalNumber' id='finalNumber' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
            <label htmlFor='columns'>Cantidad de columnas a mostrar:</label>
            <input name='columns' id='columns' onChange={(event) => setState({...state, [event.target.id]: event.target.value})}/>
            <button type="submit" disabled={props.loading}>Enviar</button>
        </form>
    </div>
}


const stateMapToPros = state => {
    return {
        loading: state.view.loading
    }
}


export default connect(stateMapToPros)(From)
