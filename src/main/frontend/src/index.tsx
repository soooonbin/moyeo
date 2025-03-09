import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Provider from "./app/Router";
import reportWebVitals from './reportWebVitals';

const rootElement = document.getElementById('root');

if (!rootElement) {
    throw new Error('Failed to find the root element');
}

const root = ReactDOM.createRoot(rootElement);
root.render(
    <React.StrictMode>
        <Provider />
    </React.StrictMode>
);
reportWebVitals();
