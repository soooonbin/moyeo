import React from 'react';
import { Box, Typography, Card, CardContent } from '@mui/material';

const SelectRoom: React.FC = () => {
    return (
        <Box
            sx={{
                height: '100vh',
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                pt: 6, // 상단 여백
            }}
        >
            {/* 제목 */}
            <Typography variant="h3" component="h1" gutterBottom>
                Select Your Vibe
            </Typography>

            {/* 카드 컨테이너 */}
            <Box
                sx={{
                    mt: 6, // 카드 컨테이너 상단 여백
                    display: 'flex',
                    gap: 20, // 카드 사이 간격
                }}
            >
                {/* 첫 번째 카드 */}
                <Card
                    sx={{
                        width: 300,
                        height: 400,
                        display: 'flex',
                        flexDirection: 'column',
                    }}
                >
                    <CardContent>
                        {/* 카드 내부 내용 */}
                        <Typography variant="h6" component="div">
                            Card 1
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            카드 1
                        </Typography>
                    </CardContent>
                </Card>

                {/* 두 번째 카드 */}
                <Card
                    sx={{
                        width: 300,
                        height: 400,
                        display: 'flex',
                        flexDirection: 'column',
                    }}
                >
                    <CardContent>
                        {/* 카드 내부 내용 */}
                        <Typography variant="h6" component="div">
                            Card 2
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            카드 2
                        </Typography>
                    </CardContent>
                </Card>
            </Box>
        </Box>
    );
};

export default SelectRoom;
