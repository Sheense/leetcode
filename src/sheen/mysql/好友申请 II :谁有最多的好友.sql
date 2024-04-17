select t.id as id, count(distinct friend) as num
from (
    select requester_id as id, accepter_id as friend from RequestAccepted
      union
    select accepter_id as id, requester_id as friend from RequestAccepted)t
group by t.id order by num desc limit 1;