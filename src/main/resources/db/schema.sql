-- 招商银行支付配置表
CREATE TABLE IF NOT EXISTS cmb_payment_config (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    merchant_id VARCHAR(64) NOT NULL COMMENT '商户ID',
    config_key VARCHAR(128) NOT NULL COMMENT '配置键',
    config_value TEXT COMMENT '配置值',
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_merchant_config (merchant_id, config_key),
    INDEX idx_merchant_id (merchant_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='招商银行支付配置表';

-- 插入示例配置数据
INSERT INTO cmb_payment_config (merchant_id, config_key, config_value) VALUES
('test_merchant_001', 'cmb.merchant.id', 'test_merchant_001'),
('test_merchant_001', 'cmb.private.key', 'your_private_key_here'),
('test_merchant_001', 'cmb.public.key', 'your_public_key_here'),
('test_merchant_001', 'cmb.api.url', 'https://api.cmbchina.com'),
('test_merchant_001', 'cmb.notify.url', 'https://your-domain.com/notify'),
('test_merchant_001', 'cmb.return.url', 'https://your-domain.com/return'),
('test_merchant_001', 'cmb.sign.type', 'RSA2'),
('test_merchant_001', 'cmb.charset', 'UTF-8'),
('test_merchant_001', 'cmb.connect.timeout', '30000'),
('test_merchant_001', 'cmb.read.timeout', '30000'),
('test_merchant_001', 'cmb.sandbox', 'false')
ON DUPLICATE KEY UPDATE config_value = VALUES(config_value);