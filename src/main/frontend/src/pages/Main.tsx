import React from 'react';
import { Box, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const Main: React.FC = () => {
    const navigate = useNavigate();

    return (
        <Box
            sx={{
                position: 'relative',
                height: '100vh',
                // 배경 이미지를 추가할 예정이면 아래 주석을 해제하고 사용하세요.
                // backgroundImage: 'url(경로/이미지파일.jpg)',
                // backgroundSize: 'cover',
                // backgroundPosition: 'center',
            }}
        >
            <Box
                sx={{
                    position: 'absolute',
                    bottom: 30, // 하단에서 약간 띄움
                    left: '50%',
                    transform: 'translateX(-50%)',
                    width: '40%', // 화면 5등분 시 가운데 3부분(60%) 정도
                    // 필요시 "조금 더 길게" 조정할 수 있음: 예를 들어 width: '65%' 등
                    textAlign: 'center'
                }}
            >
                <Button
                    variant="contained"
                    fullWidth
                    sx={{
                        padding: '16px',
                        fontSize: '1.2rem',
                        margin: '0 auto 20px auto',
                        display: 'block',
                        backgroundColor: 'white',   // 버튼 배경 흰색
                        color: 'primary.main',      // 글자색 테마 primary 색상
                        borderRadius: '30px',       // 모서리를 둥글게
                        border: '2px solid',        // 테두리 두께 설정 (2px)
                        borderColor: 'primary.main',// 테두리 색상을 글자색과 동일하게
                        boxShadow: 'none',          // 기본 그림자 제거
                        '&:hover': {
                            backgroundColor: 'grey.200',
                            boxShadow: 'none',
                        },
                    }}
                    onClick={() => navigate('/select-room')}
                >
                    START
                </Button>
            </Box>
        </Box>
    );
};

export default Main;
