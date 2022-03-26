import React, { Component } from 'react'
import From from '../components/From'
import Result from '../components/Result'

class App extends Component {// component stateful
    render() {
        return (
            <div className='container-all'>
                <div className='container-title'>
                    <h1>RANDOM NUMBERS</h1>
                </div>
                <div className='container-contain'>
                    <p className='subtitle'>RANDOM INTEGER NUMBER GENERATOR</p>
                    <div className='container-main'>
                        <From />
                        <Result />
                    </div>
                </div>
            </div>
        )
    }
}

export default App


