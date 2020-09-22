import { applyMiddleware, createStore } from 'redux'
import { composeWithDevTools } from 'redux-devtools-extension'
import rootReducer from './rootReducer'
import logger from 'redux-logger'
import thunk from 'redux-thunk'

function saveToSessionStorage(state) {
    try {
        const serializedState = JSON.stringify(state)
        sessionStorage.setItem('state', serializedState)

    } catch(e) {
        console.log(e)
    }
}

function loadFromSessionStorage() {
    try {
        const serializedState = sessionStorage.getItem('state')
        if(serializedState === null) return undefined
        return JSON.parse(serializedState)
        
    } catch (e) {
        console.log(e)
        return undefined
    }
}

const persistedState = loadFromSessionStorage()

const store = createStore(rootReducer, persistedState, composeWithDevTools(applyMiddleware(logger, thunk)))

store.subscribe(() => saveToSessionStorage(store.getState()))

export default store
