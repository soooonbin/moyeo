import { defineConfig } from 'vite';
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
    build: {
        outDir: '../build',  // React 빌드 결과를 Spring Boot로 전달
    },
});
