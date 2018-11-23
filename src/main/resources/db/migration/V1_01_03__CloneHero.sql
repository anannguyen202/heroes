CREATE OR REPLACE FUNCTION clone_data()
  RETURNS TRIGGER AS $$
BEGIN
  
  INSERT INTO hero(name)
	SELECT u.user_name
	FROM public.user u
	WHERE u.id = NEW.id;
	
  RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER trigger_user
AFTER INSERT ON public.user
FOR EACH ROW EXECUTE PROCEDURE clone_data();