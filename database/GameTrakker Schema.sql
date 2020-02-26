BEGIN TRANSACTION;
CREATE TABLE player (
        player_id SERIAL NOT NULL PRIMARY KEY,
        first_name VARCHAR(15) NOT NULL,
        last_name VARCHAR(20),
        nick_name VARCHAR(30),
        age INT,
        created_at TIMESTAMP
);

CREATE TABLE gaming_group (
        group_id SERIAL NOT NULL PRIMARY KEY,
        group_name VARCHAR(100),
        created_at TIMESTAMP
);

CREATE TABLE play_session (
        session_id SERIAL UNIQUE NOT NULL,
        session_name VARCHAR(100),
        session_date DATE,
        session_location VARCHAR(100),
        has_prize BOOLEAN DEFAULT false,
        prize VARCHAR(255),
        money_prize INT,
        group_id INT,
        created_at TIMESTAMP,
        CONSTRAINT pk_play_session_session_id_group_id PRIMARY KEY (session_id, group_id)
);
        
CREATE TABLE game (
        game_id SERIAL NOT NULL PRIMARY KEY,
        name VARCHAR(75),
        min_num_players INT DEFAULT 2,
        max_num_players INT,
        min_play_time INT,
        max_play_time INT,
        recommended_age_min INT,
        genre VARCHAR(100),
        sub_genre VARCHAR(100),
        has_dice BOOLEAN DEFAULT false,
        has_cards BOOLEAN DEFAULT false,
        has_board BOOLEAN DEFAULT false,
        has_tiles BOOLEAN DEFAULT false,
        has_figurines BOOLEAN DEFAULT false,
	has_timer BOOLEAN DEFAULT false,
	is_expansion BOOLEAN DEFAULT false,
        expansion_inv_number INT, -- [ref: inv_number]
        created_at timestamp
);

CREATE TABLE player_game_session (
        game_session_id INT NOT NULL,
        player_id INT NOT NULL,
        standing INT,
        points INT,
        score INT,
        on_team BOOLEAN DEFAULT false,
        chose_game BOOLEAN DEFAULT false,
        created_at TIMESTAMP,
        CONSTRAINT pk_player_game_session_game_session_id_player_id PRIMARY KEY (game_session_id, player_id)
);

CREATE TABLE player_group (
        player_id INT NOT NULL,
        group_id INT NOT NULL,
        created_at TIMESTAMP,
        CONSTRAINT pk_player_group_player_id_group_id PRIMARY KEY (player_id, group_id)
);

CREATE TABLE player_inventory (
        player_id INT NOT NULL,
        game_id INT NOT NULL,
        created_at TIMESTAMP,
        CONSTRAINT pk_player_inventory_player_id_game_id PRIMARY KEY (player_id, game_id)
);

CREATE TABLE game_session (
        game_session_id SERIAL NOT NULL UNIQUE,
        session_id INT NOT NULL,
        game_id INT NOT NULL,
        game_selection_type VARCHAR(25),
        created_at TIMESTAMP,
        CONSTRAINT pk_game_session_game_session_id_session_id_game_id PRIMARY KEY (game_session_id, session_id, game_id)
);

ALTER TABLE player_group
ADD FOREIGN KEY (group_id)
REFERENCES gaming_group(group_id);

ALTER TABLE player_group
ADD FOREIGN KEY (player_id)
REFERENCES player(player_id);

ALTER TABLE player_inventory
ADD FOREIGN KEY (player_id)
REFERENCES player(player_id);

ALTER TABLE player_inventory
ADD FOREIGN KEY (game_id)
REFERENCES game(game_id);

ALTER TABLE game_session
ADD FOREIGN KEY (session_id)
REFERENCES play_session(session_id);

ALTER TABLE game_session
ADD FOREIGN KEY (game_id)
REFERENCES game(game_id);

ALTER TABLE player_game_session
ADD FOREIGN KEY (player_id)
REFERENCES player(player_id);

ALTER TABLE player_game_session
ADD FOREIGN KEY (game_session_id)
REFERENCES game_session(game_session_id);

CREATE TABLE app_user(
        user_name VARCHAR(30) UNIQUE PRIMARY KEY NOT NULL,
        password VARCHAR(255) NOT NULL,
        email VARCHAR(255),
        salt varchar(255) NOT NULL
);

ALTER TABLE player
ADD user_name VARCHAR(30) UNIQUE;



--ROLLBACK;
END TRANSACTION;