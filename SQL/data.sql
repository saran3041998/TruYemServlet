//View Menu Item List Admin 
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES (1, 'sandwich', '99', 'Yes', '2017-03-15', 'Main Course', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES (2, 'Burger', '129', 'Yes', '2017-12-23', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES (3, 'Pizza', '149', 'Yes', '2018-08-21', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES (4, 'French Fries', '57', 'No', '2017-07-02', 'Starters', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES (5, 'Chocolate Brownie', '32', 'Yes', '2022-11-02', 'Dessert', 'Yes');	

//View Menu Item List Customer 
select *from menu_item where me_active='Yes' AND me_date_of_launch<=now();

//Edit Menu Item 
select *from menu_item where me_id=1;
update menu_item set me_name='chips', me_price=120, me_active='Yes', me_date_of_launch='2018-09-10', me_category='Starters', me_free_delivery='No' where me_id=1;

//Add to Cart 
insert into user(us_id,us_name)values(111111,'saranya'),(760862,'saran');

//View Cart 
select * from menu_item m inner join cart c on m.me_id=c.ct_id and c.ct_id=1;
           //sum of price
select sum(m_price) as total_price from menu_item c inner join cart c on m.me_id=c.ct_id;

//Remove item from cart
delete from cart where ct_us_id=1 and ct_pr_id=1;