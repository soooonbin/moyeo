import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Main from '../pages/Main';
import SelectRoom from "../pages/SelectRoom";

const Router: React.FC = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Main />} />
                <Route path="/select-room" element={<SelectRoom />} />
            </Routes>
        </BrowserRouter>
    );
};

export default Router;
