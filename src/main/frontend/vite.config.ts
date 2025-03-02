import { defineConfig } from 'vitest/config';
import react from '@vitejs/plugin-react';

export default defineConfig({
    plugins: [react()],
    server: {
        proxy: {
            // 기존 package.json의 proxy 설정 반영
            '/api': {
                target: 'http://localhost:8080',
                changeOrigin: true,
                secure: false,
            },
        },
    },
    test: {
        environment: 'jsdom', // DOM 환경
        globals: true,        // 전역 test, expect 활성화
        setupFiles: ['./src/setupTests.ts'], // jest-dom 등을 불러올 수도 있음
    },
});
