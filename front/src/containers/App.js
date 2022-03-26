import React, { Component } from 'react'
import From from '../components/From'
import Result from '../components/Result'

class App extends Component {// component stateful
    render() {
        return (
            <div>
                <header>
                    <h1 className='title'>RANDOM NUMBERS</h1>
                </header>
                <p className='subtitle'>RANDOM INTEGER NUMBER GENERATOR</p>
                <From />
                <Result />
            </div>
        )
    }
}

export default App


