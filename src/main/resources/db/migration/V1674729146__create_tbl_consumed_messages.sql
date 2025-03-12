CREATE TABLE IF NOT EXISTS consumed_messages (
    event_id UUID,
    time_of_receiving TIMESTAMP(6),
    version INT,
    CONSTRAINT PK_CONSUMED_MESSAGE PRIMARY KEY (event_id)
);