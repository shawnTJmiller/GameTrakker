/* DATA SETS FOR TABLES IN GAMETRAKKER DB */
BEGIN TRANSACTION;
--INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, genre, sub_genre, has_dice, has_cards, has_board, has_tiles, has_figurines, has_timer, is_expansion, expansion_inv_number)
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards, has_tiles, has_timer)
VALUES ('5 Minute Dungeon', 2, 5, 5, 45, 8, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards, has_tiles)
VALUES ('7 Wonders', 2, 7, 30, 45, 10, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards, has_board, has_tiles)
VALUES ('Alhambra', 2, 6, 30, 45, 10, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards, has_tiles)
VALUES ('Ancestree', 2, 6, 20, 25, 8, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards, has_board, has_tiles)
VALUES ('Apotheca', 1, 4, 30, 45, 14, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards)
VALUES ('Apples to Apples', 4, 10, 45, 90, 6, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_dice, has_cards)
VALUES ('BANG: The Dice Game', 3, 8, 15, 20, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_dice, has_cards, has_board, has_tiles, has_figurines)
VALUES ('Batman: Gotham City Chronicles', 2, 4, 60, 120, 12, true, true, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_dice, has_board, has_tiles, has_figurines)
VALUES ('Battlestations', 2, 9, 60, 120, 12, true, false, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards)
VALUES ('Bears vs Babies', 2, 5, 20, 30, 10, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards)
VALUES ('Beer Money', 2, 4, 15, 30, 18, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards, has_board)
VALUES ('Best Treehouse Ever: Forest of Fun', 2, 8, 20, 40, 6, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_dice, has_cards, has_tiles)
VALUES ("Betrayal at Baldur's Gate", 3, 6, 45, 75, 10, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards, has_board, has_tiles, has_figurines)
VALUES ('Blood Rage', 2, 5, 60, 90, 12, true, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, recommended_age_min, has_cards, has_board, has_tiles)
VALUES ('Brass: Birmingham', 2, 4, 120, 14, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, recommended_age_min, has_cards, has_board, has_tiles)
VALUES ('Brass: Lancashire', 2, 4, 120, 14, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_cards, has_board, has_figurines)
VALUES ('Candyland', 2, 4, 12, 20, 3, true, true, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min, has_board, has_figurines)
VALUES ('Candyland: Minnie Mouse', 2, 3, 15, 20, 3, true, true);
INSERT INTO game (name, min_num_players, min_play_time, recommended_age_min, has_cards)
VALUES ('Cards Against Humanity', 4, 30, 18, true);
INSERT INTO game (name, min_num_players, max_num_players, min_play_time, max_play_time, recommended_age_min)
VALUES ('Crocodile Dentist', 2, 5, 3);

--INSERT INTO player (first_name, last_name)
INSERT INTO player (first_name, last_name)
VALUES ('Shawn', 'Miller');
INSERT INTO player (first_name, last_name)
VALUES ('Melissa', 'Miller');
INSERT INTO player (first_name, last_name)
VALUES ('Dominic', 'Miller');
INSERT INTO player (first_name, last_name)
VALUES ('Victoria', 'Miller');
INSERT INTO player (first_name, last_name)
VALUES ('Vince', 'Bucchare');
INSERT INTO player (first_name, last_name)
VALUES ('Jen', 'Bucchare');
INSERT INTO player (first_name, last_name)
VALUES ('Mike', 'Nelson');
INSERT INTO player (first_name, last_name)
VALUES ('Nathan', 'Newcomb');
INSERT INTO player (first_name, last_name)
VALUES ('Kristin', 'Nichols');
INSERT INTO player (first_name, last_name)
VALUES ('Tom', 'Nichols');
INSERT INTO player (first_name, last_name)
VALUES ('Kelly', 'Flood');
INSERT INTO player (first_name, last_name)
VALUES ('Chris', 'Zimmerman')
INSERT INTO player (first_name, last_name)
VALUES ('Mike', 'Kraft');
INSERT INTO player (first_name, last_name)
VALUES ('Johnny', 'Bucchare');
INSERT INTO player (first_name, last_name)
VALUES ('Melanie', 'Bucchare');
INSERT INTO player (first_name, last_name)
VALUES ('Cecelia', 'Nichols');
INSERT INTO player (first_name, last_name)
VALUES ('Zachary', 'Nichols');


--INSERT INTO gaming_group (group_name)
INSERT INTO gaming_group (group_name)
VALUES ('Monday Night Gaming');
INSERT INTO gaming_group (group_name)
VALUES ('Boardgame Storyline');
INSERT INTO gaming_group (group_name)
VALUES ('Houghton Lake');
INSERT INTO 

ROLLBACK;
--END TRANSACTION;