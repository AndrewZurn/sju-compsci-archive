DROP FUNCTION IF EXISTS getTransactionTotal;
delimiter &&
CREATE FUNCTION getTransactionTotal(transNum char(5)) RETURNS double
Begin

	declare total double;
         SELECT SUM(NUMBER_ORDERED*QUOTED_PRICE) into total 
         FROM TRANS_PART
         WHERE TRANS_NUMBER = transNum;		
         return  total;
End &&
delimiter ;
