import React from 'react';
import Router from './Router';

const Provider: React.FC = () => {
    // 여기에 필요하다면 ReduxProvider, ThemeProvider 등 전역 Provider들을 추가하세요.
    return (
        <>
            <Router />
        </>
    );
};

export default Provider;
