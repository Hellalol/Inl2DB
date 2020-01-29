create
    definer = root@localhost function isOrderInDb(orderID int) returns tinyint(1)
    reads sql data
begin
    DECLARE orderFound INT default 0;
    select count(*) into orderFound from order_item where order_id = orderID;
    if orderFound = 0 then
        return false;
    else
        return true;
    end if;
end;


create procedure IncrementRowValueByOneInOrder(orderId int)

begin
    declare first int;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
            select ('SQLEXCEPTION occurred, rollback done');
        END;
    start transaction;
    set first = (select quantity from order_item where order_id = orderId);
    update order_item set quantity = first + 1 where order_id = orderId;
    commit;
end;

create procedure decrementRowValueByOneInStock(shoeId int)

begin
    declare first int;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
            select ('SQLEXCEPTION occurred, rollback done');
        END;
    start transaction;
    set first = (select stock_amount from stock where shoe_id = shoeId);
    update stock set stock_amount = first + 1 where shoe_id = shoeId;
    commit;
end;

create
    definer = root@localhost function isProductInOrder(orderID int, productID int) returns tinyint(1)
    reads sql data
begin
    DECLARE orderFound INT default 0;
    select count(*) into orderFound from order_item where order_id = orderID and product_id = productID;
    if orderFound = 0 then
        return false;
    else
        return true;
    end if;
end;


create
    definer = root@localhost function getAverageRatingForShoe(productID int) returns decimal(30, 2)
    reads sql data
begin
    declare average decimal(30, 2);
    select avg(rating_score)
    from product
             inner join review on product.id = review.product_id
             inner join rating on review.rating_id = rating.id
    where product_id = productID
    into average;
    return average;
end;


CREATE procedure addToCart(orderId int, customerId int, productId int)
begin
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
            select ('SQLEXCEPTION occurred, rollback done');
        END;
    start transaction;
    if not isOrderInDb(orderId) or orderId is null then
        insert into product_order (customer_id, date_of_order) VALUE (customerId, now());
        insert into order_item (order_id, product_id, quantity) value (last_insert_id(), productId, 1);

    else
        if isOrderInDb(orderId) is true and isProductInOrder(orderId, productId) is false then
            insert into order_item (order_id, product_id, quantity) values (orderId, productId, 1);
        else
            if isProductInOrder(orderId, productId) is true then
                call IncrementRowValueByOneInOrder(orderId, productId);
            end if;
        end if;
    end if;
    call decrementRowValueByOneInStock(productId);
    commit;
end;


create view showAverageScoreForProduct as
select concat(product.id, ' ', brand_name, ' ', color_name, ' ', size_value) as product,
       cast(avg(rating_score) as decimal(30, 2))                             as rating,
       case
           when rating_score < 2 then 'Missnöjd'
           when rating_score < 3 then 'Ganska Nöjd'
           when rating_score < 4 then 'Nöjd'
           when rating_score < 5 then 'Mycket Nöjd'
           when rating_score < 6 then 'Super Nöjd'
           when rating_score is null then 'Inga reviews'
           end                                                               as ratingtext

from product
         inner join brand on product.brand_id = brand.id
         inner join color on product.color_id = color.id
         inner join size on product.size_id = size.id
         left join review on product.id = review.product_id
         left join rating on review.rating_id = rating.id

group by product.id
order by product.id;




CREATE TRIGGER move_to_notinstock
    AFTER UPDATE ON stock
    FOR EACH ROW
BEGIN
    IF (new.stock_amount = 0) THEN
        INSERT INTO notinstock(product_id, date_time)
        VALUES(old.shoe_id, now());
    END IF;



CREATE procedure rate(customerId int, productid int,  grade int, comment varchar(100))
begin
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
            select ('SQLEXCEPTION occurred, rollback done');
        END;
    start transaction;
    insert into review (customer_id, product_id, rating_id, review_comment, date_of_review) values (customerId, productid, grade, comment, now());
    commit;
end;



use shoestoredb;