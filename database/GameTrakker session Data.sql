BEGIN TRANSACTION;

--INSERT INTO play_session(session_name, session_date, session_location, has_prize, prize, money_prize, group_id)
INSERT INTO play_session(session_name, session_date, session_location, group_id)
VALUES ('story continue', '2020-03-13', 'Bucchare House', 14);

--INSERT INTO game_session(session_id, game_id, game_selection_type)
INSERT INTO game_session(session_id, game_id, game_selection_type)
VALUES (1, 171, 'story');
INSERT INTO game_session(session_id, game_id, game_selection_type)
VALUES (1, 172, 'story');

--INSERT INTO player_game_session(game_session_id, player_id, standing, on_team, chose_game)
INSERT INTO player_game_session(game_session_id, player_id, standing, on_team)
VALUES (1, 96, 2, true);
INSERT INTO player_game_session(game_session_id, player_id, standing, on_team)
VALUES (1, 112, 2, true);
INSERT INTO player_game_session(game_session_id, player_id, standing, on_team)
VALUES (1, 100, 1, true);
INSERT INTO player_game_session(game_session_id, player_id, standing, on_team)
VALUES (1, 109, 1, true);
INSERT INTO player_game_session(game_session_id, player_id, standing)
VALUES (2, 96, 5);
INSERT INTO player_game_session(game_session_id, player_id, standing)
VALUES (2, 100, 1);
INSERT INTO player_game_session(game_session_id, player_id, standing)
VALUES (2, 112, 3);
INSERT INTO player_game_session(game_session_id, player_id, standing)
VALUES (2, 109, 6);
INSERT INTO player_game_session(game_session_id, player_id, standing)
VALUES (2, 102, 2);
INSERT INTO player_game_session(game_session_id, player_id, standing)
VALUES (2, 114, 3);