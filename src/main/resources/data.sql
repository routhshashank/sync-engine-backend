-- Seed Initial Members for Specdam Cultural Club
INSERT INTO members (roll_number, name, club, domain, year, profile_pic_url) 
VALUES ('21BD1A0501', 'Rahul Sharma', 'SPECDAM', 'DANCE', 3, 'https://i.pravatar.cc/150?img=12')
ON CONFLICT (roll_number) DO NOTHING;

INSERT INTO members (roll_number, name, club, domain, year, profile_pic_url) 
VALUES ('21BD1A0502', 'Priya Patel', 'SPECDAM', 'DANCE', 3, 'https://i.pravatar.cc/150?img=5')
ON CONFLICT (roll_number) DO NOTHING;

INSERT INTO members (roll_number, name, club, domain, year, profile_pic_url) 
VALUES ('22BD1A0515', 'Ananya Verma', 'SPECDAM', 'ART', 2, 'https://i.pravatar.cc/150?img=9')
ON CONFLICT (roll_number) DO NOTHING;
