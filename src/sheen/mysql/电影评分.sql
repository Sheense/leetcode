(select u1.name as result from  (select user_id,
                                       count(distinct movie_id) as num
                                from MovieRating
                                group by user_id) t1
                                  join Users u1
                                       on u1.user_id = t1.user_id order by t1.num desc, u1.name asc limit 1)

union
(select m1.title as result from
                                (select movie_id,
                                        avg(rating) as num
                                from MovieRating where month(created_at) = 2
                                group by movie_id)t2
                                join Movies m1
                                    on t2.movie_id = m1.movie_id
                                order by t2.num desc, m1.title asc limit 1);

