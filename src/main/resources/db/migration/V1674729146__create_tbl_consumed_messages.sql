CREATE TABLE IF NOT EXISTS consumed_messages (
    event_id UUID PRIMARY KEY,
    time_of_receiving TIMESTAMP(6),
    version INT
);