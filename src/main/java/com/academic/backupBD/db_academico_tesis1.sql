PGDMP                         z            db_academico_tesis    13.3    13.3 B    	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    173073    db_academico_tesis    DATABASE     n   CREATE DATABASE db_academico_tesis WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
 "   DROP DATABASE db_academico_tesis;
                postgres    false            ?            1259    197665    academic_period    TABLE     ?   CREATE TABLE public.academic_period (
    id bigint NOT NULL,
    acp_end_year character varying(255) NOT NULL,
    acp_start_year character varying(255) NOT NULL,
    status_id bigint NOT NULL
);
 #   DROP TABLE public.academic_period;
       public         heap    postgres    false            ?            1259    197674    academic_period_course    TABLE     v   CREATE TABLE public.academic_period_course (
    academic_period_id bigint NOT NULL,
    course_id bigint NOT NULL
);
 *   DROP TABLE public.academic_period_course;
       public         heap    postgres    false            ?            1259    197663    academic_period_id_seq    SEQUENCE        CREATE SEQUENCE public.academic_period_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.academic_period_id_seq;
       public          postgres    false    212                       0    0    academic_period_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.academic_period_id_seq OWNED BY public.academic_period.id;
          public          postgres    false    211            ?            1259    181266    course    TABLE     ?   CREATE TABLE public.course (
    id bigint NOT NULL,
    co_name character varying(255) NOT NULL,
    co_parallel character varying(255) NOT NULL,
    status_id bigint NOT NULL,
    institution_id bigint
);
    DROP TABLE public.course;
       public         heap    postgres    false            ?            1259    181264    course_id_seq    SEQUENCE     v   CREATE SEQUENCE public.course_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.course_id_seq;
       public          postgres    false    205                       0    0    course_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.course_id_seq OWNED BY public.course.id;
          public          postgres    false    204            ?            1259    173588    institution    TABLE     [  CREATE TABLE public.institution (
    id bigint NOT NULL,
    it_address character varying(255) NOT NULL,
    it_city character varying(255) NOT NULL,
    it_directors_name character varying(255) NOT NULL,
    it_email character varying(255) NOT NULL,
    it_province character varying(255) NOT NULL,
    it_registration_number character varying(255) NOT NULL,
    it_school_name character varying(255) NOT NULL,
    it_telephone_one character varying(255) NOT NULL,
    it_telephone_two character varying(255) NOT NULL,
    it_zip_code character varying(255) NOT NULL,
    status_id bigint NOT NULL
);
    DROP TABLE public.institution;
       public         heap    postgres    false            ?            1259    173586    institution_id_seq    SEQUENCE     {   CREATE SEQUENCE public.institution_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.institution_id_seq;
       public          postgres    false    201                       0    0    institution_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.institution_id_seq OWNED BY public.institution.id;
          public          postgres    false    200            ?            1259    189458    roles    TABLE     X   CREATE TABLE public.roles (
    id bigint NOT NULL,
    nombre character varying(60)
);
    DROP TABLE public.roles;
       public         heap    postgres    false            ?            1259    189456    roles_id_seq    SEQUENCE     u   CREATE SEQUENCE public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.roles_id_seq;
       public          postgres    false    207                       0    0    roles_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;
          public          postgres    false    206            ?            1259    173599    status    TABLE     ?   CREATE TABLE public.status (
    id bigint NOT NULL,
    st_keyword character varying(255),
    st_name character varying(255)
);
    DROP TABLE public.status;
       public         heap    postgres    false            ?            1259    173597    status_id_seq    SEQUENCE     v   CREATE SEQUENCE public.status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.status_id_seq;
       public          postgres    false    203                       0    0    status_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.status_id_seq OWNED BY public.status.id;
          public          postgres    false    202            ?            1259    189466    usuarios    TABLE     ?   CREATE TABLE public.usuarios (
    id bigint NOT NULL,
    email character varying(255),
    name character varying(255),
    password character varying(255),
    username character varying(255)
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            ?            1259    189464    usuarios_id_seq    SEQUENCE     x   CREATE SEQUENCE public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.usuarios_id_seq;
       public          postgres    false    209                       0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
          public          postgres    false    208            ?            1259    189475    usuarios_roles    TABLE     c   CREATE TABLE public.usuarios_roles (
    usuario_id bigint NOT NULL,
    rol_id bigint NOT NULL
);
 "   DROP TABLE public.usuarios_roles;
       public         heap    postgres    false            R           2604    197668    academic_period id    DEFAULT     x   ALTER TABLE ONLY public.academic_period ALTER COLUMN id SET DEFAULT nextval('public.academic_period_id_seq'::regclass);
 A   ALTER TABLE public.academic_period ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    212    212            O           2604    181269 	   course id    DEFAULT     f   ALTER TABLE ONLY public.course ALTER COLUMN id SET DEFAULT nextval('public.course_id_seq'::regclass);
 8   ALTER TABLE public.course ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            M           2604    173591    institution id    DEFAULT     p   ALTER TABLE ONLY public.institution ALTER COLUMN id SET DEFAULT nextval('public.institution_id_seq'::regclass);
 =   ALTER TABLE public.institution ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200    201            P           2604    189461    roles id    DEFAULT     d   ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);
 7   ALTER TABLE public.roles ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207            N           2604    173602 	   status id    DEFAULT     f   ALTER TABLE ONLY public.status ALTER COLUMN id SET DEFAULT nextval('public.status_id_seq'::regclass);
 8   ALTER TABLE public.status ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            Q           2604    189469    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    209    209                      0    197665    academic_period 
   TABLE DATA           V   COPY public.academic_period (id, acp_end_year, acp_start_year, status_id) FROM stdin;
    public          postgres    false    212   ?N                 0    197674    academic_period_course 
   TABLE DATA           O   COPY public.academic_period_course (academic_period_id, course_id) FROM stdin;
    public          postgres    false    213   ?N       ?          0    181266    course 
   TABLE DATA           U   COPY public.course (id, co_name, co_parallel, status_id, institution_id) FROM stdin;
    public          postgres    false    205   O       ?          0    173588    institution 
   TABLE DATA           ?   COPY public.institution (id, it_address, it_city, it_directors_name, it_email, it_province, it_registration_number, it_school_name, it_telephone_one, it_telephone_two, it_zip_code, status_id) FROM stdin;
    public          postgres    false    201   QO                  0    189458    roles 
   TABLE DATA           +   COPY public.roles (id, nombre) FROM stdin;
    public          postgres    false    207   LP       ?          0    173599    status 
   TABLE DATA           9   COPY public.status (id, st_keyword, st_name) FROM stdin;
    public          postgres    false    203   }P                 0    189466    usuarios 
   TABLE DATA           G   COPY public.usuarios (id, email, name, password, username) FROM stdin;
    public          postgres    false    209   ?P                 0    189475    usuarios_roles 
   TABLE DATA           <   COPY public.usuarios_roles (usuario_id, rol_id) FROM stdin;
    public          postgres    false    210   yQ                  0    0    academic_period_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.academic_period_id_seq', 1, false);
          public          postgres    false    211                       0    0    course_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.course_id_seq', 13, true);
          public          postgres    false    204                       0    0    institution_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.institution_id_seq', 69, true);
          public          postgres    false    200                       0    0    roles_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.roles_id_seq', 2, true);
          public          postgres    false    206                       0    0    status_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.status_id_seq', 62, true);
          public          postgres    false    202                       0    0    usuarios_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuarios_id_seq', 3, true);
          public          postgres    false    208            n           2606    197678 2   academic_period_course academic_period_course_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.academic_period_course
    ADD CONSTRAINT academic_period_course_pkey PRIMARY KEY (academic_period_id, course_id);
 \   ALTER TABLE ONLY public.academic_period_course DROP CONSTRAINT academic_period_course_pkey;
       public            postgres    false    213    213            l           2606    197673 $   academic_period academic_period_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.academic_period
    ADD CONSTRAINT academic_period_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.academic_period DROP CONSTRAINT academic_period_pkey;
       public            postgres    false    212            ^           2606    181274    course course_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.course DROP CONSTRAINT course_pkey;
       public            postgres    false    205            T           2606    173596    institution institution_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.institution
    ADD CONSTRAINT institution_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.institution DROP CONSTRAINT institution_pkey;
       public            postgres    false    201            b           2606    189463    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    207            X           2606    173607    status status_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.status DROP CONSTRAINT status_pkey;
       public            postgres    false    203            V           2606    173609 &   institution uk329141ouy739m7toqpueagwi 
   CONSTRAINT     k   ALTER TABLE ONLY public.institution
    ADD CONSTRAINT uk329141ouy739m7toqpueagwi UNIQUE (it_school_name);
 P   ALTER TABLE ONLY public.institution DROP CONSTRAINT uk329141ouy739m7toqpueagwi;
       public            postgres    false    201            Z           2606    173617 "   status ukald4lpo3rbnychqigcognrt16 
   CONSTRAINT     l   ALTER TABLE ONLY public.status
    ADD CONSTRAINT ukald4lpo3rbnychqigcognrt16 UNIQUE (st_name, st_keyword);
 L   ALTER TABLE ONLY public.status DROP CONSTRAINT ukald4lpo3rbnychqigcognrt16;
       public            postgres    false    203    203            \           2606    173619 "   status ukd9hbg5a6pmbb8thmb0k3xb305 
   CONSTRAINT     `   ALTER TABLE ONLY public.status
    ADD CONSTRAINT ukd9hbg5a6pmbb8thmb0k3xb305 UNIQUE (st_name);
 L   ALTER TABLE ONLY public.status DROP CONSTRAINT ukd9hbg5a6pmbb8thmb0k3xb305;
       public            postgres    false    203            d           2606    189483 $   usuarios ukkfsp0s1tflm1cwlj8idhqsad0 
   CONSTRAINT     `   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT ukkfsp0s1tflm1cwlj8idhqsad0 UNIQUE (email);
 N   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT ukkfsp0s1tflm1cwlj8idhqsad0;
       public            postgres    false    209            f           2606    189481 $   usuarios ukm2dvbwfge291euvmk6vkkocao 
   CONSTRAINT     c   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT ukm2dvbwfge291euvmk6vkkocao UNIQUE (username);
 N   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT ukm2dvbwfge291euvmk6vkkocao;
       public            postgres    false    209            `           2606    181276 "   course ukt671361mmd6wfehvbc7fa8g3d 
   CONSTRAINT     `   ALTER TABLE ONLY public.course
    ADD CONSTRAINT ukt671361mmd6wfehvbc7fa8g3d UNIQUE (co_name);
 L   ALTER TABLE ONLY public.course DROP CONSTRAINT ukt671361mmd6wfehvbc7fa8g3d;
       public            postgres    false    205            h           2606    189474    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    209            j           2606    189479 "   usuarios_roles usuarios_roles_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.usuarios_roles
    ADD CONSTRAINT usuarios_roles_pkey PRIMARY KEY (usuario_id, rol_id);
 L   ALTER TABLE ONLY public.usuarios_roles DROP CONSTRAINT usuarios_roles_pkey;
       public            postgres    false    210    210            t           2606    197679 +   academic_period fk4u70jqppj4bdkmn66aokvmtq4    FK CONSTRAINT     ?   ALTER TABLE ONLY public.academic_period
    ADD CONSTRAINT fk4u70jqppj4bdkmn66aokvmtq4 FOREIGN KEY (status_id) REFERENCES public.status(id);
 U   ALTER TABLE ONLY public.academic_period DROP CONSTRAINT fk4u70jqppj4bdkmn66aokvmtq4;
       public          postgres    false    2904    203    212            r           2606    189484 *   usuarios_roles fk5338ehgluufgc8bpj08nrq970    FK CONSTRAINT     ?   ALTER TABLE ONLY public.usuarios_roles
    ADD CONSTRAINT fk5338ehgluufgc8bpj08nrq970 FOREIGN KEY (rol_id) REFERENCES public.roles(id);
 T   ALTER TABLE ONLY public.usuarios_roles DROP CONSTRAINT fk5338ehgluufgc8bpj08nrq970;
       public          postgres    false    2914    207    210            o           2606    173610 '   institution fk64fi1jwr4754d7t37n2dhl6l3    FK CONSTRAINT     ?   ALTER TABLE ONLY public.institution
    ADD CONSTRAINT fk64fi1jwr4754d7t37n2dhl6l3 FOREIGN KEY (status_id) REFERENCES public.status(id);
 Q   ALTER TABLE ONLY public.institution DROP CONSTRAINT fk64fi1jwr4754d7t37n2dhl6l3;
       public          postgres    false    2904    203    201            v           2606    197689 2   academic_period_course fkcjxd603yysp9y09bueyab12hu    FK CONSTRAINT     ?   ALTER TABLE ONLY public.academic_period_course
    ADD CONSTRAINT fkcjxd603yysp9y09bueyab12hu FOREIGN KEY (academic_period_id) REFERENCES public.academic_period(id);
 \   ALTER TABLE ONLY public.academic_period_course DROP CONSTRAINT fkcjxd603yysp9y09bueyab12hu;
       public          postgres    false    2924    213    212            q           2606    181282 "   course fkeia6xjuespxibcj584q9k69b1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.course
    ADD CONSTRAINT fkeia6xjuespxibcj584q9k69b1 FOREIGN KEY (institution_id) REFERENCES public.institution(id);
 L   ALTER TABLE ONLY public.course DROP CONSTRAINT fkeia6xjuespxibcj584q9k69b1;
       public          postgres    false    2900    201    205            p           2606    181277 "   course fkk3fm9x315nugeg7ar9nr9whm9    FK CONSTRAINT     ?   ALTER TABLE ONLY public.course
    ADD CONSTRAINT fkk3fm9x315nugeg7ar9nr9whm9 FOREIGN KEY (status_id) REFERENCES public.status(id);
 L   ALTER TABLE ONLY public.course DROP CONSTRAINT fkk3fm9x315nugeg7ar9nr9whm9;
       public          postgres    false    205    203    2904            u           2606    197684 2   academic_period_course fkq4mw5lp8kevjyms7eego2r19k    FK CONSTRAINT     ?   ALTER TABLE ONLY public.academic_period_course
    ADD CONSTRAINT fkq4mw5lp8kevjyms7eego2r19k FOREIGN KEY (course_id) REFERENCES public.course(id);
 \   ALTER TABLE ONLY public.academic_period_course DROP CONSTRAINT fkq4mw5lp8kevjyms7eego2r19k;
       public          postgres    false    213    2910    205            s           2606    189489 *   usuarios_roles fkqcxu02bqipxpr7cjyj9dmhwec    FK CONSTRAINT     ?   ALTER TABLE ONLY public.usuarios_roles
    ADD CONSTRAINT fkqcxu02bqipxpr7cjyj9dmhwec FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);
 T   ALTER TABLE ONLY public.usuarios_roles DROP CONSTRAINT fkqcxu02bqipxpr7cjyj9dmhwec;
       public          postgres    false    2920    210    209                  x?????? ? ?            x?????? ? ?      ?   0   x?3?,,??+?7?t?4???2?????Ɯ%??%
???I`?=... ?v      ?   ?   x???MN?0FדS????aǞ+?1?)??R"DN??R???#Y???<???Ӌ'(<??????IR?>e???J?R?X?C7R???????6????p??S???????V???b?y?{??U?03?????ޏ0?+BR??A?pk'7?? ?!?"?#??????!_Zº??O_?-<???h?\ɫ
??????? ?R????b?X???+?2l(??v	?4t]?׎?0          !   x?3???q?v?2??]|=??b???? t??      ?      x?3?LL.?̲|.s?̼D?pc???? ??	?         ?   x???M?0????<k["uK?^?dE?Sl25[???G?];=??C4?fpa??? )x??t<?k??ml?s?o?OK?c_??̥?????Q9	ۤuj??,s?J?C ?1????LJvN?????F???Bq?O'?Uگ@?m?E?e???@--??x??`???????5?????}??h ???G`?            x?3?4?2?4?2?=... :     