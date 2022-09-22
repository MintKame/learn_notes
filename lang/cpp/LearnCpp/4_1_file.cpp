/*
 * @Author: your name
 * @Date: 2020-10-12 09:57:44
 * @LastEditTime: 2021-06-27 22:20:10
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \cpp\LearnCpp\9_1_input.cpp
 */
#include <iostream>
#include <filesystem> // C++ 17, contains: paths, regular files, and dirs
using namespace std;
//! alias
namespace fs = std::filesystem; // alias of namespace, for convient
//  using TN = TypeName;        // alias of cls / type
int main(int argc, char const *argv[])
{

    std::cout << "file separator is: " << fs::path::preferred_separator << std::endl;
    // "\\" represent \ 

    fs::path ps[3]{"tmp.cpp",                        // relative
                   "c:/coding/cpp/LearnCpp/tmp.cpp", // absolute
                   "c:/coding/"};
    for (auto &p : ps)
    {
        file_type(p);
    }
    return 0;
}

void file_type(fs::path p)
{

    if (fs::is_regular_file(p))
    {
        std::cout << p << "'s size is: " << fs::file_size(p) << std::endl;
    }
    else if (fs::is_directory(p)) // print all files in dir
    {
        std::cout << p << "is a directory, includes: " << std::endl;
        for (auto &e : fs::directory_iterator(p))
        {
            std::cout << "  " << e.path() << '\n';
        }
    }
    else if (fs::exists(p))
    {
        std::cout << p << " is a special file\n";
    }
    else
    {
        std::cout << p << " does not exist" << std::endl;
    }
}

void sub(fs::path p)
{
    if (p.empty())
    {
        cout << "Path " << p << " is empty." << endl;
    }
    if (!fs::exists(p))
    {
        cout << "Path " << p << " does not exist." << endl;
    }
    // eg: c:\\coding\\cpp\\LearnCpp\\9_1_file.cpp
    cout << "root_name(): " << p.root_name() << "\n" // c:
         << "root_path(): " << p.root_path() << "\n" // c:\\ 
         << "relative_path(): " << p.relative_path() << "\n"; // 9_1_file.cpp
        cout
         << "parent_path(): " << p.parent_path() << "\n" // c:\\coding\\cpp\\LearnCpp
         << "filename(): " << p.filename() << "\n"       // 9_1_file.cpp
         << "stem(): " << p.stem() << "\n"               // 9_1_file
         << "extension(): " << p.extension() << endl;    // .cpp
}

void concat()
{
    // append, /=: add /
    fs::path p1{"c:/coding"};
    p1.append(R"(cpp)"); // c:/coding/cpp
    p1 /= R"(LearnCpp)"; // c:/coding/cpp/LearnCpp
    cout << p1 << endl;

    // concat, +=: not add /
    fs::path p2{"c:/coding"};
    p2.concat(R"(cpp)"); // c:/codingcpp
    p2 += R"(LearnCpp)"; // c:/codingcppLearnCpp
    cout << p2 << endl;

    // /
    fs::path p3 = "";
    p3 = p3 / R"(C:\coding)" / R"(cpp)" / R"(LearnCpp)";
    cout << p3 << endl;
}

void disk_space()
{
    fs::path p{"C:\\"};
    fs::space_info info = fs::space(p);
    cout << "C: total space: " << info.capacity << endl;
    cout << "C: free  space: " << info.free << endl;
    // space() return an obj space_info
}