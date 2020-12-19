USE homework;
insert into TABLE user_info
SELECT COUNT(DISTINCT id), TO_DATE(click_time)
FROM user_clicks
WHERE TO_DATE(click_time) = current_date
GROUP BY  TO_DATE(click_time);